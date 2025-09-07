/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.network

import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import ke.don.birdie.feedback.model.domain.BirdieResult
import ke.don.birdie.feedback.model.domain.NetworkError
import ke.don.birdie.feedback.model.domain.NetworkErrorCategory
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

internal suspend inline fun <reified T> klient(
    crossinline call: suspend () -> HttpResponse,
): BirdieResult<T, NetworkError> = try {
    val response = call()
    val statusCode = response.status.value

    if (statusCode in 200..299) {
        BirdieResult.Success(response.body<T>())
    } else {
        BirdieResult.Error(
            NetworkError(
                category = statusCode.toCategory(),
                message = response.status.description,
                code = statusCode
            )
        )
    }
} catch (e: Exception) {
    BirdieResult.Error(
        NetworkError(
            category = e.toCategory(),
            message = e.message,
            code = null
        )
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
    is SocketTimeoutException -> NetworkErrorCategory.REQUEST_TIMEOUT
    is IOException -> NetworkErrorCategory.NO_INTERNET
    is SerializationException -> NetworkErrorCategory.SERIALIZATION
    else -> NetworkErrorCategory.UNKNOWN
}
