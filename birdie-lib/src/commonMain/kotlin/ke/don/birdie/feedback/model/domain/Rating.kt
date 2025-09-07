package ke.don.birdie.feedback.model.domain

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.jvm.JvmInline

@Serializable(with = RatingSerializer::class)
@JvmInline
value class Rating(val value: Int) {
    init {
        require(value in 1..5) { "Rating must be between 1 and 5" }
    }
}

object RatingSerializer : KSerializer<Rating> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Rating", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Rating) {
        encoder.encodeInt(value.value)
    }

    override fun deserialize(decoder: Decoder): Rating {
        val intValue = decoder.decodeInt()
        if (intValue !in 1..5) {
            // Fail safely instead of crashing later
            throw IllegalArgumentException("Invalid rating: $intValue (must be 1..5)")
        }
        return Rating(intValue)
    }
}
