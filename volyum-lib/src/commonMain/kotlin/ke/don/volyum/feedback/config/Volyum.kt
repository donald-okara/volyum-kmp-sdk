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

import ke.don.volyum.feedback.model.domain.NetworkError
import ke.don.volyum.feedback.model.domain.VolyumResult
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.volyum.feedback.model.table.Feedback
import ke.don.volyum.feedback.network.api.ApiClient

/**
 * The main entry point for interacting with the Volyum feedback system.
 * This class provides methods for sending, retrieving, and managing feedback.
 *
 * It is constructed internally and accessed via the `VolyumFactory.create()` method.
 *
 * @property apiClient The [ApiClient] used for making network requests.
 */
class Volyum internal constructor(
    private val apiClient: ApiClient,
) {
    /**
     * Sends feedback to the Volyum API.
     *
     * @param feedback The feedback to send.
     * @return A [VolyumResult] containing the sent feedback or a [NetworkError] if an error occurred.
     */
    suspend fun sendFeedback(
        feedback: Feedback,
    ): VolyumResult<Feedback, NetworkError> =
        apiClient.addFeedback(feedback = feedback)

    /**
     * Retrieves a list of feedback entries based on the provided filter.
     *
     * This function makes an API call to fetch feedback. The results can be filtered
     * using the [GetFeedbackFilter] object.
     *
     * @param filter The filter criteria to apply when fetching feedback.
     * @return A [VolyumResult] which is either a [VolyumResult.Success] containing a list of [Feedback] objects
     *         or a [VolyumResult.Error] containing a [NetworkError] if the request fails.
     */
    suspend fun getFeedback(
        filter: GetFeedbackFilter,
    ): VolyumResult<List<Feedback>, NetworkError> =
        apiClient.getFeedback(filter)

    /**
     * Retrieves a feedback item by its unique identifier.
     *
     * This function makes an API call to fetch a specific feedback item based on the provided ID.
     *
     * @param id The unique identifier of the feedback to retrieve.
     * @return A [VolyumResult] which is either a [VolyumResult.Success] containing the [Feedback] object
     *         or a [VolyumResult.Error] containing a [NetworkError] if the request fails.
     */
    suspend fun getFeedbackById(
        id: String,
    ): VolyumResult<Feedback, NetworkError> =
        apiClient.getFeedbackById(id = id)
}
