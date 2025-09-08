package ke.don.birdie.feedback.model.domain.data_transfer

import ke.don.birdie.feedback.model.table.Feedback
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddFeedbackRequest(
    @SerialName("project_id")val projectId: String,
    @SerialName("api_key")val key: String,
    @SerialName("feedback") val feedback: Feedback,
)