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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the request to get feedback by its ID.
 *
 * @property projectId The ID of the project.
 * @property apiKey The API key for authentication.
 * @property feedbackId The ID of the feedback to retrieve.
 */
@Serializable
data class GetFeedbackByIdRequest(
    @SerialName("project_id")val projectId: String,
    @SerialName("api_key")val apiKey: String,
    @SerialName("feedback_id")val feedbackId: String,
)
