/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.network

import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.util.reflect.*
import ke.don.volyum.feedback.model.domain.NetworkError
import ke.don.volyum.feedback.model.domain.NetworkErrorCategory
import ke.don.volyum.feedback.model.domain.VolyumResult
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal suspend inline fun <reified T> klient(
    crossinline call: suspend () -> HttpResponse,
): VolyumResult<T, NetworkError> = try {
    val response = call()
    val statusCode = response.status.value

    if (statusCode in 200..299) {
        // 👇 Pass typeInfo to help Ktor decode lists properly
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

private fun Int.toCategory(): NetworkErrorCategory = when (this) {
    401 -> NetworkErrorCategory.UNAUTHORIZED
    409 -> NetworkErrorCategory.CONFLICT
    408 -> NetworkErrorCategory.REQUEST_TIMEOUT
    413 -> NetworkErrorCategory.PAYLOAD_TOO_LARGE
    in 500..599 -> NetworkErrorCategory.SERVER_ERROR
    else -> NetworkErrorCategory.UNKNOWN
}

private fun Exception.toCategory(): NetworkErrorCategory = when (this) {
    is ConnectTimeoutException,
    is SocketTimeoutException,
    -> NetworkErrorCategory.REQUEST_TIMEOUT
    is IOException -> NetworkErrorCategory.NO_INTERNET
    is SerializationException -> NetworkErrorCategory.SERIALIZATION
    else -> NetworkErrorCategory.UNKNOWN
}
