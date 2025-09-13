/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ke.don.volyum.feedback.model.table.FeedbackStatus

/**
 * Returns the color associated with the [FeedbackStatus].
 *
 * This Composable function maps each [FeedbackStatus] to a specific color
 * from the current [MaterialTheme.colorScheme].
 *
 * @return The [Color] corresponding to the feedback status:
 *  - [FeedbackStatus.Pending] -> `MaterialTheme.colorScheme.primary`
 *  - [FeedbackStatus.Reviewed] -> `MaterialTheme.colorScheme.tertiary`
 *  - [FeedbackStatus.Resolved] -> `MaterialTheme.colorScheme.secondary`
 *  - [FeedbackStatus.Rejected] -> `MaterialTheme.colorScheme.error`
 */
@Composable
fun FeedbackStatus.color(): Color {
    return when (this) {
        FeedbackStatus.Pending -> MaterialTheme.colorScheme.primary
        FeedbackStatus.Reviewed -> MaterialTheme.colorScheme.tertiary
        FeedbackStatus.Resolved -> MaterialTheme.colorScheme.secondary
        FeedbackStatus.Rejected -> MaterialTheme.colorScheme.error
    }
}
