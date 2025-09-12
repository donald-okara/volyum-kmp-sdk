/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.demo.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ke.don.birdie.feedback.model.table.FeedbackStatus

@Composable
fun FeedbackStatus.color(): Color {
    return when (this) {
        FeedbackStatus.Pending -> MaterialTheme.colorScheme.primary
        FeedbackStatus.Reviewed -> MaterialTheme.colorScheme.tertiary
        FeedbackStatus.Resolved -> MaterialTheme.colorScheme.secondary
        FeedbackStatus.Rejected -> MaterialTheme.colorScheme.error
    }
}
