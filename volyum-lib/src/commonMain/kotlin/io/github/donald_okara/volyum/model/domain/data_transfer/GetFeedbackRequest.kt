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

import io.github.donald_okara.volyum.model.table.FeedbackStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request to retrieve feedback.
 *
 * @property projectId The ID of the project.
 * @property apiKey The API key for authentication.
 * @property userId The ID of the user (optional).
 * @property targetId The ID of the target (optional).
 * @property targetType The type of the target (optional).
 * @property status The status of the feedback (optional).
 * @property limit The maximum number of feedback items to retrieve (optional).
 * @property offset The offset for pagination (optional).
 */
@Serializable
data class GetFeedbackRequest(
    @SerialName("project_id")val projectId: String,
    @SerialName("api_key")val apiKey: String,
    @SerialName("user_id")val userId: String? = null,
    @SerialName("target_id")val targetId: String? = null,
    @SerialName("target_type")val targetType: String? = null,
    val status: FeedbackStatus? = null,
    val limit: Int? = null,
    val offset: Int? = null,
)
