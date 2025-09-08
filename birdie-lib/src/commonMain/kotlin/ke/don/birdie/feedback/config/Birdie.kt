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

import ke.don.birdie.feedback.model.domain.BirdieResult
import ke.don.birdie.feedback.model.domain.NetworkError
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.network.api.ApiClient

class Birdie internal constructor(
    private val apiClient: ApiClient,
) {
    suspend fun sendFeedback(feedback: Feedback): BirdieResult<Feedback, NetworkError> = apiClient.addFeedback(feedback = feedback)
}
