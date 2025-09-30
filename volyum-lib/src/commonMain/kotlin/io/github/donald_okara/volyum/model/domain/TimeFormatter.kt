/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.model.domain

import io.github.donald_okara.volyum.helpers.logger
import kotlinx.datetime.*
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

/**
 * An object that provides utility functions for formatting time.
 */
object TimeFormatter {

    /**
     * Formats a count and a singular noun into a plural string, adding "ago".
     *
     * For example, `plural(1, "minute")` returns "1 minute ago", and
     * `plural(2, "minute")` returns "2 minutes ago".
     *
     * @param count The number of items.
     * @param singular The singular form of the noun.
     * @return A string representing the pluralized count and noun, followed by "ago".
     */
    fun plural(count: Long, singular: String): String {
        return "$count $singular${if (count != 1L) "s" else ""} ago"
    }

    /**
     * Logger instance for the TimeFormatter object.
     * Used for logging messages, errors, and debugging information related to time formatting.
     */
    val log = logger<TimeFormatter>()

    /**
     * Formats a timestamp string into a relative time string (e.g., "Just now", "5 minutes ago", "Yesterday").
     *
     * The input timestamp is expected to be in a format similar to Postgres timestamptz
     * (e.g., "2025-09-09 10:15:00.000000+00"). It normalizes this into an ISO-8601 format
     * before parsing.
     *
     * The function handles different time differences:
     * - Less than 1 minute: "Just now"
     * - Less than 60 minutes: "X minutes ago"
     * - Less than 24 hours: "X hours ago"
     * - Yesterday (based on calendar days in the specified `timeZone`): "Yesterday"
     * - Less than 7 days: "X days ago"
     * - Otherwise: Formats as "Month Day, Year" (e.g., "September 9, 2025")
     *
     * If an error occurs during parsing or formatting, the original timestamp string is returned.
     *
     * @param timestamp The timestamp string to format.
     * @param timeZone The timezone to use for determining calendar days (defaults to the current system default timezone).
     * @return A string representing the relative time, or the original timestamp if formatting fails.
     */
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
