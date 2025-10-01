/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.model.table

import io.github.donald_okara.volyum.model.domain.TimeFormatter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a feedback entry.
 *
 * @property id The unique identifier of the feedback.
 * @property userId The ID of the user who submitted the feedback.
 * @property targetId The ID of the target entity (e.g., product, service) the feedback is about.
 * @property targetType The type of the target entity.
 * @property createdAt The timestamp when the feedback was created.
 * @property closingRemarks Any closing remarks associated with the feedback.
 * @property userMetadata Additional metadata about the user.
 * @property text The main content of the feedback.
 * @property rating The rating given by the user, if applicable (must be between 1 and 5).
 * @property status The current status of the feedback.
 */
@Serializable
data class Feedback(
    val id: String? = null,
    @SerialName("user_id")val userId: String? = null,
    @SerialName("project_id")val projectId: String? = null,
    @SerialName("target_id")val targetId: String? = null,
    @SerialName("target_type")val targetType: String? = null,
    @SerialName("created_at")val createdAt: String = "",
    @SerialName("closing_remarks")val closingRemarks: String? = null,
    @SerialName("user_metadata")val userMetadata: UserMetadata? = UserMetadata(),
    val text: String? = "",
    val rating: Int? = null,
    val status: FeedbackStatus = FeedbackStatus.Pending,
) {
    init {
        require(rating == null || rating in 1..5) { "Rating must be between 1 and 5" }
    }

    /**
     * Formats the `createdAt` timestamp into a human-readable relative time string.
     *
     * For example, "2 minutes ago", "1 hour ago", "yesterday".
     *
     * @return A formatted string representing the relative time since the feedback was created,
     * or an empty string if `createdAt` is empty.
     */
    fun formatTimestamp(): String {
        if (createdAt.isEmpty()) {
            return ""
        }
        return TimeFormatter.formatRelativeTime(createdAt)
    }
}
