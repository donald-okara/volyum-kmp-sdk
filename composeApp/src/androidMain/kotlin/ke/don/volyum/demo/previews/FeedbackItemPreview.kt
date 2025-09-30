/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.previews

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter
import io.github.donald_okara.volyum.model.table.Feedback
import io.github.donald_okara.volyum.model.table.FeedbackStatus
import ke.don.volyum.demo.components.FeedbackItem
import ke.don.volyum.demo.components.ProfileHeader
import ke.don.volyum.demo.components.RatingRow
import ke.don.volyum.demo.models.UserData
import ke.don.volyum.demo.theme.VolyumTheme

@DevicePreviews
@Composable
fun FeedbackItemPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    VolyumTheme(darkTheme = darkTheme) {
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
    VolyumTheme(darkTheme = darkTheme) {
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
    VolyumTheme(darkTheme = darkTheme) {
        Surface {
            RatingRow(
                rating = 3,
                timestamp = "2023-09-09T10:15:00.000000+00:00",
            )
        }
    }
}
