//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.domain](../index.md)/[TimeFormatter](index.md)/[formatRelativeTime](format-relative-time.md)

# formatRelativeTime

[common]\
fun [formatRelativeTime](format-relative-time.md)(timestamp: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), timeZone: TimeZone = TimeZone.currentSystemDefault()): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)

Formats a timestamp string into a relative time string (e.g., &quot;Just now&quot;, &quot;5 minutes ago&quot;, &quot;Yesterday&quot;).

The input timestamp is expected to be in a format similar to Postgres timestamptz (e.g., &quot;2025-09-09 10:15:00.000000+00&quot;). It normalizes this into an ISO-8601 format before parsing.

The function handles different time differences:

- 
   Less than 1 minute: &quot;Just now&quot;
- 
   Less than 60 minutes: &quot;X minutes ago&quot;
- 
   Less than 24 hours: &quot;X hours ago&quot;
- 
   Yesterday (based on calendar days in the specified `timeZone`): &quot;Yesterday&quot;
- 
   Less than 7 days: &quot;X days ago&quot;
- 
   Otherwise: Formats as &quot;Month Day, Year&quot; (e.g., &quot;September 9, 2025&quot;)

If an error occurs during parsing or formatting, the original timestamp string is returned.

#### Return

A string representing the relative time, or the original timestamp if formatting fails.

#### Parameters

common

| | |
|---|---|
| timestamp | The timestamp string to format. |
| timeZone | The timezone to use for determining calendar days (defaults to the current system default timezone). |