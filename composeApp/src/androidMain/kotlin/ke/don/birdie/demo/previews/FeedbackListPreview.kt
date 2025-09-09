/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.demo.previews

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter
import ke.don.birdie.demo.FeedbackState
import ke.don.birdie.demo.models.UserData
import ke.don.birdie.demo.screens.FeedbackList
import ke.don.birdie.demo.theme.BirdieTheme
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.model.table.FeedbackStatus

val feedbackList = listOf(
    Feedback(
        id = "1",
        userId = "456",
        rating = 4,
        status = FeedbackStatus.Pending,
        text = "The app is great, but it would be even better if we could customize the notification sounds. Keep up the good work!",
        createdAt = "2023-09-09T10:15:00.000000+00:00",
        userMetadata = UserData().getRandom().toMetadata(),
    ),
    Feedback(
        id = "2",
        userId = "456",
        status = FeedbackStatus.Rejected,
        rating = 2,
        text = "I found a bug where the app crashes when I try to upload a photo. Please fix this ASAP!",
        createdAt = "2023-09-08T14:30:00.000000+00:00",
        userMetadata = UserData().getRandom().toMetadata(),
    ),
    Feedback(
        id = "3",
        userId = "456",
        status = FeedbackStatus.Resolved,
        rating = 5,
        text = "Thank you for fixing the photo upload bug so quickly! The app is working perfectly now. Amazing support!",
        createdAt = "2023-09-10T09:00:00.000000+00:00",
        userMetadata = UserData().getRandom().toMetadata(),
    ),
    Feedback(
        id = "4",
        userId = "456",
        status = FeedbackStatus.Reviewed,
        rating = 3,
        text = "The new feature is interesting, but the user interface feels a bit cluttered. Maybe simplify the layout?",
        createdAt = "2023-09-07T18:45:00.000000+00:00",
        userMetadata = UserData().getRandom().toMetadata(),
    ),
)
val state = FeedbackState(
    feedbackList = feedbackList,
)

@DevicePreviews
@Composable
fun FeedbackListPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackList(
                state = state,
                handleIntent = {},
            )
        }
    }
}
