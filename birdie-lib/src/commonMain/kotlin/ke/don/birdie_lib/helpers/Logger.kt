package ke.don.birdie_lib.helpers

import co.touchlab.kermit.Logger

inline fun <reified T> logger(): Logger {
    return Logger.withTag(T::class.simpleName ?: "Birdie")
}