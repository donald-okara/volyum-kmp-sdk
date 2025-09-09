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
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ke.don.birdie.demo.components.FeedbackItem
import ke.don.birdie.demo.components.ProfileHeader
import ke.don.birdie.demo.components.RatingRow
import ke.don.birdie.demo.models.UserData
import ke.don.birdie.demo.theme.BirdieTheme
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.model.table.FeedbackStatus

class BooleanPreviewParameterProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(true, false)
}

@DevicePreviews
@Composable
fun FeedbackItemPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackItem(
                item = Feedback(
                    id = "123",
                    userId = "456",
                    rating = 4,
                    status = FeedbackStatus.Pending,
                    targetType = "Books",
                    text = "This is a sample feedback item.",
                    createdAt = "2023-09-09T10:15:00.000000+00:00",
                    userMetadata = UserData().getRandom().toMetadata(),
                ),
            )
        }
    }
}

@DevicePreviews
@Composable
fun ProfileHeaderPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            ProfileHeader(
                userData = UserData().getRandom(),
            )
        }
    }
}

@DevicePreviews
@Composable
fun RatingRowPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            RatingRow(
                rating = 3,
                timestamp = "2023-09-09T10:15:00.000000+00:00",
            )
        }
    }
}
