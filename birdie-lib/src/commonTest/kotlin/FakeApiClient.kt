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
import ke.don.birdie.feedback.model.domain.BirdieResult
import ke.don.birdie.feedback.model.domain.NetworkError
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.network.api.ApiClient

class FakeApiClient : ApiClient {
    override suspend fun addFeedback(feedback: Feedback): BirdieResult<Feedback, NetworkError> {
        return if (feedback.id == "0") {
            return BirdieResult.Error(NetworkError())
        } else {
            BirdieResult.Success(fakeFeedbackItem)
        }
    }

    override suspend fun getFeedback(
        limit: Int?,
        offset: Int?,
        userId: String?,
        targetId: String?,
        targetType: String?,
    ): BirdieResult<List<Feedback>, NetworkError> {
        return if (userId == "0") {
            return BirdieResult.Error(NetworkError())
        } else {
            BirdieResult.Success(fakeFeedbackList)
        }
    }

    override suspend fun getFeedbackById(id: String): BirdieResult<Feedback, NetworkError> {
        return if (id == "0") {
            return BirdieResult.Error(NetworkError())
        } else {
            BirdieResult.Success(fakeFeedbackItem)
        }
    }
}
