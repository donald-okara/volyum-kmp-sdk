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

/**
 * Data class representing the filter options for retrieving feedback.
 *
 * @property limit The maximum number of feedback items to retrieve.
 * @property offset The number of feedback items to skip before starting to retrieve.
 * @property userId The ID of the user who submitted the feedback.
 * @property targetId The ID of the target entity for which the feedback was submitted.
 * @property targetType The type of the target entity (e.g., "product", "service").
 * @property status The status of the feedback (e.g., "pending", "resolved").
 */
data class GetFeedbackFilter(
    val limit: Int? = null,
    val offset: Int? = null,
    val userId: String? = null,
    val targetId: String? = null,
    val targetType: String? = null,
    val status: FeedbackStatus? = null,
)
