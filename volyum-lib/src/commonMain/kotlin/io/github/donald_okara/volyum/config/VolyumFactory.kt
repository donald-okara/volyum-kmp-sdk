/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.config

import io.github.donald_okara.volyum.network.api.ApiClient
import io.github.donald_okara.volyum.network.api.ApiClientImpl

/**
 * Factory for creating [Volyum] instances.
 *
 * This object provides a convenient way to initialize and configure the Volyum SDK.
 * It handles the internal setup of dependencies like the [ApiClient].
 */
object VolyumFactory {
    /**
     * Creates a new instance of [Volyum] with the provided configuration.
     *
     * This is the primary entry point for initializing the Volyum feedback library.
     *
     * @param config The [VolyumConfig] object containing the necessary settings for Volyum.
     * @return A new instance of [Volyum] ready to be used.
     */
    fun create(config: VolyumConfig): Volyum {
        return createInternal(config)
    }

    /**
     * Creates a new Volyum instance with the given configuration and API client.
     *
     * This function is intended for internal use and testing purposes. It allows for injecting
     * a custom [ApiClient] which can be useful for mocking network requests during tests.
     *
     * @param config The [VolyumConfig] object containing the necessary settings for Volyum.
     * @param apiClient The [ApiClient] to be used for making network requests.
     *                  Defaults to an instance of `ApiClientImpl` initialized with the project identifier
     *                  derived from the provided `config`.
     * @return A new instance of [Volyum] configured with the given parameters.
     */
    @PublishedApi
    internal fun createInternal(config: VolyumConfig, apiClient: ApiClient = ApiClientImpl(config.toProjectIdentifier())): Volyum {
        return Volyum(apiClient)
    }
}
