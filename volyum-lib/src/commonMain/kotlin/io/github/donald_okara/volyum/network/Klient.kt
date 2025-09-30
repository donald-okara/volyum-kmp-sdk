/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.network

import io.github.donald_okara.volyum.model.domain.NetworkError
import io.github.donald_okara.volyum.model.domain.NetworkErrorCategory
import io.github.donald_okara.volyum.model.domain.VolyumResult
import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.util.reflect.*
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/**
 * A wrapper around Ktor's HTTP client that handles common network operations and error handling.
 *
 * This function simplifies making network requests by:
 * - Executing the provided `call` lambda, which should return an `HttpResponse`.
 * - Checking the HTTP status code of the response.
 * - If the status code is in the 2xx range (successful):
 *     - It attempts to deserialize the response body into the specified type `T`.
 *     - It returns a `VolyumResult.Success` containing the deserialized data.
 * - If the status code is not in the 2xx range (error):
 *     - It attempts to parse the error response body as JSON to extract a "message" field.
 *     - If parsing fails or the "message" field is not found, it uses the HTTP status description as the error message.
 *     - It returns a `VolyumResult.Error` containing a `NetworkError` object with the appropriate category, message, and status code.
 * - If any other exception occurs during the network call (e.g., `IOException`, `SerializationException`):
 *     - It catches the exception.
 *     - It returns a `VolyumResult.Error` containing a `NetworkError` object with the appropriate category based on the exception type and the exception message.
 *
 * @param T The expected type of the successful response body. This type must be reified, meaning its type information is available at runtime, which is necessary for Ktor's deserialization.
 * @param call A suspend lambda function that performs the actual network request and returns an `HttpResponse`. This lambda is `crossinline` to prevent non-local returns.
 * @return A `VolyumResult` which is either:
 *         - `VolyumResult.Success<T>` containing the deserialized response data if the request was successful.
 *         - `VolyumResult.Error<NetworkError>` containing a `NetworkError` object if the request failed or an exception occurred.
 */
internal suspend inline fun <reified T> klient(
    crossinline call: suspend () -> HttpResponse,
): VolyumResult<T, NetworkError> = try {
    val response = call()
    val statusCode = response.status.value

    if (statusCode in 200..299) {
        // Pass typeInfo to help Ktor decode lists properly
        VolyumResult.Success(response.body(typeInfo<T>()) as T)
    } else {
        val errorBody = response.bodyAsText()
        val errorMessage = try {
            val json = Json.parseToJsonElement(errorBody).jsonObject
            json["message"]?.jsonPrimitive?.content ?: response.status.description
        } catch (e: Exception) {
            response.status.description
        }
        VolyumResult.Error(
            NetworkError(
                category = statusCode.toCategory(),
                message = errorMessage,
                code = statusCode,
            ),
        )
    }
} catch (e: Exception) {
    VolyumResult.Error(
        NetworkError(
            category = e.toCategory(),
            message = e.message,
            code = null,
        ),
    )
}

/**
 * Converts an HTTP status code to a [NetworkErrorCategory].
 *
 * This function maps common HTTP error codes to predefined categories,
 * simplifying error handling and categorization.
 *
 * @return The corresponding [NetworkErrorCategory] for the given HTTP status code.
 *         Returns [NetworkErrorCategory.UNKNOWN] if the status code doesn't match
 *         any predefined category.
 */
private fun Int.toCategory(): NetworkErrorCategory = when (this) {
    408 -> NetworkErrorCategory.REQUEST_TIMEOUT // Request Timeout
    401 -> NetworkErrorCategory.UNAUTHORIZED // Unauthorized
    409 -> NetworkErrorCategory.CONFLICT // Conflict
    429 -> NetworkErrorCategory.TOO_MANY_REQUESTS // Rate limiting
    413 -> NetworkErrorCategory.PAYLOAD_TOO_LARGE // Payload Too Large
    in 500..599 -> NetworkErrorCategory.SERVER_ERROR // Server-side errors
    else -> NetworkErrorCategory.UNKNOWN
}

/**
 * Converts an [Exception] to a [NetworkErrorCategory].
 *
 * This function helps categorize network-related exceptions into meaningful error types
 * for better error handling and user feedback.
 *
 * @return The corresponding [NetworkErrorCategory] for the exception.
 */
private fun Exception.toCategory(): NetworkErrorCategory = when (this) {
    is ConnectTimeoutException,
    is SocketTimeoutException,
    -> NetworkErrorCategory.REQUEST_TIMEOUT
    is IOException -> NetworkErrorCategory.NO_INTERNET
    is SerializationException -> NetworkErrorCategory.SERIALIZATION
    else -> NetworkErrorCategory.UNKNOWN
}
