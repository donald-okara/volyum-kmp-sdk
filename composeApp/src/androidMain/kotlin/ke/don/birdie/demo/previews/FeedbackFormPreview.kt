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
import ke.don.birdie.demo.components.RatingInput
import ke.don.birdie.demo.screens.FeedbackForm
import ke.don.birdie.demo.screens.FormHeader
import ke.don.birdie.demo.theme.BirdieTheme

@DevicePreviews
@Composable
fun FormPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackForm(
                state = state,
                onEvent = {},
            )
        }
    }
}

@DevicePreviews
@Composable
fun FormHeaderPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            FormHeader()
        }
    }
}

@DevicePreviews
@Composable
fun RatingPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            RatingInput(
                rating = 3,
                onRatingChange = {},
            )
        }
    }
}
