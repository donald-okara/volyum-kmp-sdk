package ke.don.birdie.feedback.model.table

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserMetadata(
    val username: String? = null,
    @SerialName("profile_url")val profileUrl: String? = null
)