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

/**
 * Provides the platform-specific HTTP client engine.
 *
 * This function is an `expect` function, meaning its actual implementation
 * will be provided by platform-specific `actual` declarations (e.g., for Android, iOS, JVM).
 *
 * @return An [HttpClientEngineFactory] suitable for the current platform.
 */
internal expect fun provideEngine(): HttpClientEngineFactory<*>

/**
 * Provides a configured Ktor HTTP client instance for making network requests.
 *
 * This object is responsible for setting up the Ktor client with necessary plugins:
 * - **HttpTimeout**: Configures request, connection, and socket timeouts.
 * - **ContentNegotiation**: Enables JSON serialization/deserialization using Kotlinx Serialization.
 *   - `encodeDefaults = false`: Avoids sending default values in JSON payloads.
 *   - `explicitNulls = false`: Skips explicit null values in JSON payloads.
 *   - `ignoreUnknownKeys = true`: Allows parsing JSON with unknown keys without errors.
 *   - `prettyPrint = true`: Formats JSON output for better readability (useful for debugging).
 *   - `isLenient = true`: Allows for more lenient JSON parsing.
 * - **Logging**: Enables logging of HTTP requests and responses.
 *   - `level = LogLevel.BODY`: Logs the entire request and response body.
 *   - `logger = compactKtorLogger()`: Uses a custom logger for compact output.
 *
 * The HTTP client engine is provided by the platform-specific `provideEngine()` function.
 */
internal object KtorClientProvider {
    /**
     * The [HttpClient] instance used for making network requests.
     * It is configured with:
     * - [HttpTimeout]: Sets timeouts for requests, connections, and sockets.
     * - [ContentNegotiation]: Configures JSON serialization/deserialization using Kotlinx Serialization.
     * - [Logging]: Enables logging of HTTP requests and responses.
     */
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
                    coerceInputValues = true
                },
            )
        }

        install(Logging) {
            level = LogLevel.BODY
            logger = compactKtorLogger()
        }
    }
}
