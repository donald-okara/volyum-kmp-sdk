package ke.don.birdie.feedback.model.domain

import kotlinx.datetime.*
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.days

object TimeFormatter {

    fun formatRelativeTime(
        timestamp: String,
        timeZone: TimeZone = TimeZone.currentSystemDefault()
    ): String {
        // Postgres timestamptz looks like: 2025-09-09 10:15:00.000000+00
        // Normalize into ISO-8601 (2025-09-09T10:15:00.000000+00:00)
        val normalized = timestamp
            .replace(" ", "T")
            .replace(Regex("(\\+|-)\\d{2}$")) { match -> match.value + ":00" }

        val instant = Instant.parse(normalized)
        val now = Clock.System.now()

        val zonedDateTime = instant.toLocalDateTime(timeZone)
        val nowZoned = now.toLocalDateTime(timeZone)

        val diff = now - instant

        return when {
            diff < 1.minutes -> "Just now"
            diff < 60.minutes -> "${diff.inWholeMinutes} minute${if (diff.inWholeMinutes != 1L) "s" else ""} ago"
            diff < 24.hours -> "${diff.inWholeHours} hour${if (diff.inWholeHours != 1L) "s" else ""} ago"
            // Compare calendar days in local timezone
            zonedDateTime.date == nowZoned.date.minus(1, DateTimeUnit.DAY) -> "Yesterday"
            diff < 7.days -> "${diff.inWholeDays} days ago"
            else -> "${zonedDateTime.date.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${zonedDateTime.date.dayOfMonth}, ${zonedDateTime.date.year}"
        }
    }
}
