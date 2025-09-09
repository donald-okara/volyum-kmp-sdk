/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.model.table

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feedback(
    val id: String? = null,
    @SerialName("user_id")val userId: String,
    @SerialName("target_id")val targetId: String,
    @SerialName("target_type")val targetType: String,
    @SerialName("closing_remarks")val closingRemarks: String? = null,
    @SerialName("user_metadata")val userMetadata: UserMetadata? = UserMetadata(),
    val text: String,
    val rating: Int? = null,
    val status: FeedbackStatus = FeedbackStatus.Pending,
) {
    init {
        require(rating == null || rating in 1..5) { "Rating must be between 1 and 5" }
    }
}
