/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie_lib.network.api

import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ke.don.birdie_lib.helpers.logger
import ke.don.birdie_lib.model.BirdieResult
import ke.don.birdie_lib.model.NetworkError
import ke.don.birdie_lib.model.TestData
import ke.don.birdie_lib.network.KtorClientProvider
import ke.don.birdie_lib.network.KtorClientProvider.client
import ke.don.birdie_lib.network.klient

object BirdieApi {
    private val log = logger<BirdieApi>()

    suspend fun fetchTestData(): BirdieResult<List<TestData>, NetworkError> = klient {
        client.get(Endpoint.TestTable.url) {
            contentType(ContentType.Application.Json)
            parameter("select", "*")
        }
    }
}
