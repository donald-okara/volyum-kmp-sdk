package ke.don.birdie.feedback.model.domain

import ke.don.birdie.feedback.model.table.Feedback
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddFeedbackRequest(
    @SerialName("p_project_id")val projectId: String,
    @SerialName("p_api_key")val key: String,
    @SerialName("p_feedback") val feedback: Feedback
)