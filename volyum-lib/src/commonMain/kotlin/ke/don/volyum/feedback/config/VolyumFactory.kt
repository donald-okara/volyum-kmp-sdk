/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.config

import ke.don.volyum.feedback.network.api.ApiClient
import ke.don.volyum.feedback.network.api.ApiClientImpl

object VolyumFactory {
    fun create(config: VolyumConfig): Volyum {
        return createInternal(config)
    }

    @PublishedApi
    internal fun createInternal(config: VolyumConfig, apiClient: ApiClient = ApiClientImpl(config.toProjectIdentifier())): Volyum {
        return Volyum(apiClient)
    }
}
