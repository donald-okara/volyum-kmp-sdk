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
