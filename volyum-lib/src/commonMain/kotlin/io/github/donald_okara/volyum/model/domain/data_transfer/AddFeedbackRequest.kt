/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.model.domain.data_transfer

import io.github.donald_okara.volyum.model.table.Feedback
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the request to add feedback.
 *
 * @property projectId The unique identifier of the project to which the feedback belongs.
 * @property key The API key for authorizing the request.
 * @property feedback The feedback object containing the feedback details.
 */
@Serializable
data class AddFeedbackRequest(
    @SerialName("project_id")val projectId: String,
    @SerialName("api_key")val key: String,
    @SerialName("feedback") val feedback: Feedback,
)
