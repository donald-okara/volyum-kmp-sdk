package ke.don.birdie.feedback.model.domain.data_transfer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetFeedbackRequest(
    @SerialName("project_id")val projectId: String,
    @SerialName("api_key")val apiKey: String,
    @SerialName("user_id")val userId: String? = null,
    @SerialName("target_id")val targetId: String? = null,
    @SerialName("target_type")val targetType: String? = null,
    val limit: Int? = null,
    val offset: Int? = null
)