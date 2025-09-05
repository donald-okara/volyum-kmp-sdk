package ke.don.birdie_lib.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual fun provideEngine(): HttpClientEngineFactory<*> = Darwin
