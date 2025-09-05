package ke.don.birdie_lib.model

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class TestData(
    val id: Long,
    val text: String? = null
)