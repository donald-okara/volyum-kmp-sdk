package ke.don.birdie.demo.previews

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ke.don.birdie.demo.components.FeedbackItemShimmer
import ke.don.birdie.demo.screens.ClosingRemarksComponent
import ke.don.birdie.demo.screens.FeedbackDetailsScreen
import ke.don.birdie.demo.theme.BirdieTheme

@DevicePreviews
@Composable
fun FeedbackDetailsScreenPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackDetailsScreen(
                state = state,
                handleIntent = {},
            )
        }
    }
}

@DevicePreviews
@Composable
fun FeedbackItemShimmerPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackItemShimmer()
        }
    }
}


@DevicePreviews
@Composable
fun ClosingRemarksPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
) {
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            ClosingRemarksComponent(
                text = "The issue was resolved by updating the user's account information and verifying their identity through our secure portal. The user confirmed that they are now able to access their account without any issues."
            )
        }
    }
}