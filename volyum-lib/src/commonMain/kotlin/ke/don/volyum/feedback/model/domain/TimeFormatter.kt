/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.model.domain

import ke.don.volyum.feedback.helpers.logger
import kotlinx.datetime.*
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

object TimeFormatter {

    fun plural(count: Long, singular: String): String {
        return "$count $singular${if (count != 1L) "s" else ""} ago"
    }
    val log = logger<TimeFormatter>()
    fun formatRelativeTime(
        timestamp: String,
        timeZone: TimeZone = TimeZone.currentSystemDefault(),
    ): String {
        try { // Postgres timestamptz looks like: 2025-09-09 10:15:00.000000+00
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
                diff < 60.minutes -> plural(diff.inWholeMinutes, "minute")
                diff < 24.hours -> plural(diff.inWholeHours, "hour")

                // Compare calendar days in local timezone
                zonedDateTime.date == nowZoned.date.minus(1, DateTimeUnit.DAY) -> "Yesterday"
                diff < 7.days -> plural(diff.inWholeDays, "day")
                else -> "${zonedDateTime.date.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${zonedDateTime.date.dayOfMonth}, ${zonedDateTime.date.year}"
            }
        } catch (e: Exception) {
            log.d("Error formatting relative time: $e")
            return timestamp
        }
    }
}
