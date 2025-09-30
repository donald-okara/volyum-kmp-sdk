/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.network.api

import io.github.donald_okara.volyum.model.domain.NetworkError
import io.github.donald_okara.volyum.model.domain.VolyumResult
import io.github.donald_okara.volyum.model.domain.data_transfer.GetFeedbackFilter
import io.github.donald_okara.volyum.model.table.Feedback

/**
 * Interface for interacting with the feedback API.
 * Defines methods for adding, retrieving, and filtering feedback.
 */
internal interface ApiClient {
    /**
     * Adds feedback to the Volyum service.
     *
     * @param feedback The feedback object to add.
     * @return A [VolyumResult] indicating success or failure.
     *         If successful, the result contains the added [Feedback] object.
     *         If failed, the result contains a [NetworkError] object.
     */
    suspend fun addFeedback(
        feedback: Feedback,
    ): VolyumResult<Feedback, NetworkError>

    /**
     * Retrieves a list of feedback entries based on the provided filter.
     *
     * This function sends a request to the server to fetch feedback entries that match the criteria
     * specified in the `filter` parameter. The filter can be used to narrow down the results,
     * for example, by user ID, rating, or date range.
     *
     * @param filter An object containing the filtering criteria for fetching feedback.
     * @return A `VolyumResult` object. If the request is successful, it contains a list of
     *         `Feedback` objects. If there's an error, it contains a `NetworkError` object
     *         detailing the issue.
     */
    suspend fun getFeedback(
        filter: GetFeedbackFilter,
    ): VolyumResult<List<Feedback>, NetworkError>

    /**
     * Retrieves a feedback item by its unique identifier.
     *
     * @param id The unique identifier of the feedback to retrieve.
     * @return A [VolyumResult] containing the [Feedback] if successful, or a [NetworkError] if an error occurs.
     */
    suspend fun getFeedbackById(
        id: String,
    ): VolyumResult<Feedback, NetworkError>
}
