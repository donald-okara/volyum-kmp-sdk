package ke.don.birdie_lib.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import ke.don.birdie_lib.BuildKonfig
import ke.don.birdie_lib.helpers.logger
import kotlinx.serialization.json.Json

expect fun provideEngine(): HttpClientEngineFactory<*>

object KtorClientProvider {
    private val log = logger<KtorClientProvider>()


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
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                },
            )
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    log.d(message)
                }
            }
            level = LogLevel.BODY
        }

        install(DefaultRequest) {
            header("apiKey", BuildKonfig.SUPABASE_ANON_KEY)
        }

    }
}
