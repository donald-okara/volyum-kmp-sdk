/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.helpers

import io.ktor.client.plugins.logging.*

/**
 * Creates a Ktor [Logger] that logs request and response details in a compact format.
 *
 * It buffers log messages and flushes them when a "REQUEST:" or "RESPONSE:" line is encountered.
 * This helps to group related log entries together.
 *
 * For example, a typical log output might look like:
 * ```
 * REQUEST: https://api.example.com/data | METHOD: GET
 * RESPONSE: 200 OK | BODY: {"key": "value"}
 * ```
 * Instead of multiple individual lines for headers, body, etc.
 *
 * It uses `co.touchlab.kermit.Logger` with the tag "Volyum" for actual logging.
 */
internal fun compactKtorLogger(): Logger = object : Logger {
    private val logger = co.touchlab.kermit.Logger.withTag("Volyum")
    private val buffer = mutableListOf<String>()

    /**
     * Logs a message.
     *
     * This function buffers log messages. When a "REQUEST:" or "RESPONSE:" message is encountered,
     * the current buffer is flushed (logged as a single line), and the new message is added to the
     * buffer. For "RESPONSE:" messages, the buffer is flushed again immediately after adding the
     * message. Other messages are simply added to the buffer.
     *
     * @param message The message to log.
     */
    override fun log(message: String) {
        when {
            message.startsWith("REQUEST:") -> {
                flushBuffer()
                buffer.add(message)
            }
            message.startsWith("RESPONSE:") -> {
                flushBuffer()
                buffer.add(message)
                flushBuffer()
            }
            else -> buffer.add(message)
        }
    }

    /**
     * Flushes the current buffer to the logger if it's not empty.
     *
     * This function checks if the internal `buffer` contains any log messages.
     * If the buffer is not empty, it joins all messages in the buffer with " | "
     * as a separator and logs the resulting string using the debug level (`logger.d`).
     * After logging, the buffer is cleared to prepare for new messages.
     */
    private fun flushBuffer() {
        if (buffer.isNotEmpty()) {
            logger.d(buffer.joinToString(" | "))
            buffer.clear()
        }
    }
}
