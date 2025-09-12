/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
import FakeFeedbackData.fakeFeedbackItem
import FakeFeedbackData.fakeFeedbackList
import ke.don.volyum.feedback.model.domain.NetworkError
import ke.don.volyum.feedback.model.domain.VolyumResult
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.volyum.feedback.model.table.Feedback
import ke.don.volyum.feedback.network.api.ApiClient

class FakeApiClient : ApiClient {
    override suspend fun addFeedback(feedback: Feedback): VolyumResult<Feedback, NetworkError> {
        return if (feedback.id == "0") {
            return VolyumResult.Error(NetworkError())
        } else {
            VolyumResult.Success(fakeFeedbackItem)
        }
    }

    override suspend fun getFeedback(
        filter: GetFeedbackFilter,
    ): VolyumResult<List<Feedback>, NetworkError> {
        return if (filter.userId == "0") {
            return VolyumResult.Error(NetworkError())
        } else {
            VolyumResult.Success(fakeFeedbackList)
        }
    }

    override suspend fun getFeedbackById(id: String): VolyumResult<Feedback, NetworkError> {
        return if (id == "0") {
            return VolyumResult.Error(NetworkError())
        } else {
            VolyumResult.Success(fakeFeedbackItem)
        }
    }
}
