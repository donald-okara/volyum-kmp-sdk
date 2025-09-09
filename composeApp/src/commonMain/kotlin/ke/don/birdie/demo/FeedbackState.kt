package ke.don.birdie.demo

import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.birdie.feedback.model.table.Feedback

data class FeedbackState(
    val filter: GetFeedbackFilter = GetFeedbackFilter(),
    val feedbackList: List<String> = emptyList(),
    val listErrorMessage: String? = null,
    val listIsLoading: Boolean = false,
    val listIsError: Boolean = false,

    val readFeedback: Feedback = Feedback(),
    val readErrorMessage: String? = null,
    val readIsLoading: Boolean = false,
    val readIsError: Boolean = false,

    val sendFeedback: Feedback = Feedback(),
    val sendErrorMessage: String? = null,
    val sendIsLoading: Boolean = false,
    val sendIsError: Boolean = false,
)
