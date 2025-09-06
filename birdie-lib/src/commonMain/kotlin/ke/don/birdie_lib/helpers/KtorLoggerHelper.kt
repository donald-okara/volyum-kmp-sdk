/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie_lib.helpers

import io.ktor.client.plugins.logging.*

internal fun compactKtorLogger(): Logger = object : Logger {
    private val logger = co.touchlab.kermit.Logger.withTag("Birdie")
    private val buffer = mutableListOf<String>()

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

    private fun flushBuffer() {
        if (buffer.isNotEmpty()) {
            logger.d(buffer.joinToString(" | "))
            buffer.clear()
        }
    }
}
