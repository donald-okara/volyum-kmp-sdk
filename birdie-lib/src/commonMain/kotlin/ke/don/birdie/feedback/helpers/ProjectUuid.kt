package ke.don.birdie.feedback.helpers

import kotlin.jvm.JvmInline

@JvmInline
value class EntityUUID(val value: String) {
    init {
        require(value.matches(Regex("^[0-9a-fA-F-]{36}\$"))) {
            "Invalid UUID format: $value"
        }
    }

    override fun toString(): String = value
}
