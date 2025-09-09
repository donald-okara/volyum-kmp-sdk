package ke.don.birdie.feedback.model.table

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FeedbackStatus {
    @SerialName("pending")
    Pending,

    @SerialName("reviewed")
    Reviewed,

    @SerialName("resolved")
    Resolved,

    @SerialName("rejected")
    Rejected,
}