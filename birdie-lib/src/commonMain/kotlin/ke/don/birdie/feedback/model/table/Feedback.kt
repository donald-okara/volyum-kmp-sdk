package ke.don.birdie.feedback.model.table

import ke.don.birdie.feedback.model.domain.Rating
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
    val rating: Rating?
)