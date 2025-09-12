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

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import ke.don.volyum.feedback.helpers.compactKtorLogger
import kotlinx.serialization.json.Json

expect fun provideEngine(): HttpClientEngineFactory<*>

internal object KtorClientProvider {
    // This will store the session provider, which we'll set manually
    val client = HttpClient(provideEngine()) {
        install(HttpTimeout) {
            requestTimeoutMillis = 30_000 // or higher
            connectTimeoutMillis = 15_000
            socketTimeoutMillis = 30_000
        }

        install(ContentNegotiation) {
            json(
                Json {
                    encodeDefaults = false
                    explicitNulls = false
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                },
            )
        }

        install(Logging) {
            level = LogLevel.BODY
            logger = compactKtorLogger()
        }
    }
}
