/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.model.domain.data_transfer

import ke.don.birdie.feedback.model.table.FeedbackStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
