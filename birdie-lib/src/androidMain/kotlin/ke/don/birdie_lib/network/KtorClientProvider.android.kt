package ke.don.birdie_lib.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp

actual fun provideEngine(): HttpClientEngineFactory<*> = OkHttp
