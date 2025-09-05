/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie_lib.network

import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import ke.don.birdie_lib.helpers.logger
import ke.don.birdie_lib.model.BirdieResult
import ke.don.birdie_lib.model.NetworkError
import ke.don.birdie_lib.network.api.BirdieApi
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

internal suspend inline fun <reified T> klient(
    crossinline call: suspend () -> HttpResponse,
): BirdieResult<T, NetworkError> {
    return try {
        val response = call()
        when (response.status.value) {
            in 200..299 -> {
                val body = response.body<T>()
                BirdieResult.Success(body)
            }

            401 -> BirdieResult.Error(NetworkError.UNAUTHORIZED)
            409 -> BirdieResult.Error(NetworkError.CONFLICT)
            408 -> BirdieResult.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> BirdieResult.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> BirdieResult.Error(NetworkError.SERVER_ERROR)
            else -> BirdieResult.Error(NetworkError.UNKNOWN)
        }
    } catch (e: ConnectTimeoutException) {
        BirdieResult.Error(NetworkError.REQUEST_TIMEOUT)
    } catch (e: SocketTimeoutException) {
        BirdieResult.Error(NetworkError.REQUEST_TIMEOUT)
    } catch (e: IOException) {
        BirdieResult.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        BirdieResult.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        BirdieResult.Error(NetworkError.UNKNOWN)
    }
}
