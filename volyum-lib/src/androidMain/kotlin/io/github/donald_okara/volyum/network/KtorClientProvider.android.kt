package io.github.donald_okara.volyum.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp

internal actual fun provideEngine(): HttpClientEngineFactory<*> = OkHttp
