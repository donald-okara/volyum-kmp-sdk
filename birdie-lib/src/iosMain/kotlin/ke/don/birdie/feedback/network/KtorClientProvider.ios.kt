package ke.don.birdie.feedback.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual fun provideEngine(): HttpClientEngineFactory<*> = Darwin
