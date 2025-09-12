/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.network.api

import ke.don.volyum.feedback.model.domain.VolyumResult
import ke.don.volyum.feedback.model.domain.NetworkError
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.volyum.feedback.model.table.Feedback

internal interface ApiClient {
    suspend fun addFeedback(
        feedback: Feedback,
    ): VolyumResult<Feedback, NetworkError>

    suspend fun getFeedback(
        filter: GetFeedbackFilter,
    ): VolyumResult<List<Feedback>, NetworkError>

    suspend fun getFeedbackById(
        id: String,
    ): VolyumResult<Feedback, NetworkError>
}
