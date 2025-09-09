package ke.don.birdie.demo.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ke.don.birdie.demo.FeedbackState
import ke.don.birdie.demo.components.FeedbackItem
import ke.don.birdie.demo.models.DemoIntentHandler

@Composable
fun FeedbackList(
    modifier: Modifier = Modifier,
    state: FeedbackState,
    handleIntent: (DemoIntentHandler) -> Unit,
) {

    Surface(
        modifier = Modifier
            .widthIn(max = 420.dp)      // phone-like width
    ) {
        if (state.listIsLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn(
                modifier = Modifier,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.feedbackList) {
                    FeedbackItem(
                        item = it,
                        isPreview = true,
                        onClick = {
                            handleIntent(DemoIntentHandler.GetFeedbackById(it.id!!))
                        }
                    )
                }
            }


        }
    }
}
