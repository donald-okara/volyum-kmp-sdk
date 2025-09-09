package ke.don.birdie.demo.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ke.don.birdie.feedback.model.table.FeedbackStatus

@Composable
fun FeedbackStatus.color(): Color {
    return when(this){
        FeedbackStatus.Pending -> MaterialTheme.colorScheme.primary
        FeedbackStatus.Reviewed -> MaterialTheme.colorScheme.tertiary
        FeedbackStatus.Resolved -> MaterialTheme.colorScheme.secondary
        FeedbackStatus.Rejected -> MaterialTheme.colorScheme.error
    }
}