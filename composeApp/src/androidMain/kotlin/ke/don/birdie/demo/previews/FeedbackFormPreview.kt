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
){
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            FeedbackForm(
                state = state,
                onEvent = {}
            )
        }
    }
}

@DevicePreviews
@Composable
fun FormHeaderPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class)
    darkTheme: Boolean,
){
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
){
    BirdieTheme(darkTheme = darkTheme) {
        Surface {
            RatingInput(
                rating = 3,
                onRatingChange = {}
            )
        }
    }
}