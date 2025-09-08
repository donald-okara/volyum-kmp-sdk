package ke.don.birdie.feedback.model.domain.data_transfer

import kotlinx.serialization.SerialName

data class GetFeedbackByIdRequest(
    @SerialName("project_id")val projectId: String,
    @SerialName("api_key")val apiKey: String,
    @SerialName("feedback_id")val feedbackId: String
)
