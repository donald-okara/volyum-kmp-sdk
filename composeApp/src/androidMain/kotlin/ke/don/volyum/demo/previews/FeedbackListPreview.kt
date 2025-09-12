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
import ke.don.volyum.demo.screens.FeedbackFilterRow
import ke.don.volyum.demo.screens.FeedbackList
import ke.don.volyum.demo.theme.VolyumTheme

@DevicePreviews
@Composable
fun FeedbackListPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    VolyumTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackList(
                state = state,
                handleIntent = {},
            )
        }
    }
}

@DevicePreviews
@Composable
fun FeedbackFilterRowPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    VolyumTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackFilterRow(
                filter = state.filter,
                onFilterChange = {},
            )
        }
    }
}
