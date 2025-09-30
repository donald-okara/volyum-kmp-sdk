package io.github.donald_okara.volyum.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

internal actual fun provideEngine(): HttpClientEngineFactory<*> = Darwin
