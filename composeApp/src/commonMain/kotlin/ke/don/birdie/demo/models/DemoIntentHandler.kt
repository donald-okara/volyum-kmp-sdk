package ke.don.birdie.demo.models

import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.model.table.FeedbackStatus

sealed class DemoIntentHandler {
    data class GetFeedback(
        val filter: GetFeedbackFilter
    ): DemoIntentHandler()

    data class GetFeedbackById(
        val id: String,
    ): DemoIntentHandler()

    data class SendFeedback(
        val feedback: Feedback,
    ): DemoIntentHandler()
}