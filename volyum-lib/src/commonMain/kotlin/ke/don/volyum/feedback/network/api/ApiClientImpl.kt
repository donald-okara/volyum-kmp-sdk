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

import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ke.don.volyum.feedback.model.domain.NetworkError
import ke.don.volyum.feedback.model.domain.ProjectIdentity
import ke.don.volyum.feedback.model.domain.VolyumResult
import ke.don.volyum.feedback.model.domain.data_transfer.AddFeedbackRequest
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackByIdRequest
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackRequest
import ke.don.volyum.feedback.model.table.Feedback
import ke.don.volyum.feedback.network.KtorClientProvider.client
import ke.don.volyum.feedback.network.klient

/**
 * Implementation of the [ApiClient] interface.
 *
 * This class handles communication with the Volyum backend API.
 *
 * @property projectIdentity The project identity used for authentication.
 */
internal class ApiClientImpl(
    private val projectIdentity: ProjectIdentity,
) : ApiClient {
    /**
     * Adds feedback to the Volyum backend.
     *
     * @param feedback The feedback to add.
     * @return A [VolyumResult] containing the added feedback or a [NetworkError] if an error occurs.
     */
    override suspend fun addFeedback(
        feedback: Feedback,
    ): VolyumResult<Feedback, NetworkError> = klient<Feedback> {
        client.post(Endpoint.Functions.AddFeedback.url) {
            contentType(ContentType.Application.Json)
            setBody(
                AddFeedbackRequest(
                    projectId = projectIdentity.id,
                    key = projectIdentity.key,
                    feedback = feedback,
                ),
            )
        }
    }

    /**
     * Retrieves a list of feedback items based on the provided filter.
     *
     * This function sends a POST request to the GetFeedback endpoint with the filter criteria.
     * The project identity (ID and key) is automatically included in the request.
     *
     * @param filter The [GetFeedbackFilter] object containing the criteria to filter feedback.
     * @return A [VolyumResult] which is either a [VolyumResult.Success] containing a list of [Feedback] objects,
     *         or a [VolyumResult.Error] containing a [NetworkError].
     */
    override suspend fun getFeedback(
        filter: GetFeedbackFilter,
    ): VolyumResult<List<Feedback>, NetworkError> = klient {
        client.post(Endpoint.Functions.GetFeedback.url) {
            contentType(ContentType.Application.Json)
            setBody(
                GetFeedbackRequest(
                    projectId = projectIdentity.id,
                    apiKey = projectIdentity.key,
                    userId = filter.userId,
                    targetId = filter.targetId,
                    targetType = filter.targetType,
                    status = filter.status,
                    limit = filter.limit,
                    offset = filter.offset,
                ),
            )
        }
    }

    /**
     * Retrieves a feedback item by its ID.
     *
     * @param id The ID of the feedback item to retrieve.
     * @return A [VolyumResult] containing the [Feedback] item if successful, or a [NetworkError] if an error occurs.
     */
    override suspend fun getFeedbackById(
        id: String,
    ): VolyumResult<Feedback, NetworkError> = klient<Feedback> {
        client.post(Endpoint.Functions.GetFeedbackById.url) {
            contentType(ContentType.Application.Json)
            setBody(
                GetFeedbackByIdRequest(
                    projectId = projectIdentity.id,
                    apiKey = projectIdentity.key,
                    feedbackId = id,
                ),
            )
        }
    }
}
