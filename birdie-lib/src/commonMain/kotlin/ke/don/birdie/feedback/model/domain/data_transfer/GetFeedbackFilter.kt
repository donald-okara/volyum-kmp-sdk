package ke.don.birdie.feedback.model.domain.data_transfer

import ke.don.birdie.feedback.model.table.FeedbackStatus

data class GetFeedbackFilter(
    val limit: Int? = null,
    val offset: Int? = null,
    val userId: String? = null,
    val targetId: String? = null,
    val targetType: String? = null,
    val status: FeedbackStatus? = null
)
