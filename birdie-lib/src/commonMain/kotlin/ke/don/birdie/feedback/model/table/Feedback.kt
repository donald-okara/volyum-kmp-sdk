package ke.don.birdie.feedback.model.table

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
data class Feedback(
    val id: String? = null,
    @SerialName("user_id")val userId: String,
    @SerialName("target_id")val targetId: String,
    @SerialName("target_type")val targetType: String,
    val text: String,
    val rating: Int? = null
) {
    init {
        require(rating == null || rating in 1..5) { "Rating must be between 1 and 5" }
    }
}


