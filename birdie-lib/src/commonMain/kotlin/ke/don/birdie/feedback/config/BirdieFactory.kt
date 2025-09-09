/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.config

import ke.don.birdie.feedback.network.api.ApiClient
import ke.don.birdie.feedback.network.api.ApiClientImpl

object BirdieFactory {
    fun create(config: BirdieConfig): Birdie {
        return createInternal(config)
    }

    @PublishedApi
    internal fun createInternal(config: BirdieConfig, apiClient: ApiClient = ApiClientImpl(config.toProjectIdentifier())): Birdie {
        return Birdie(apiClient)
    }
}
