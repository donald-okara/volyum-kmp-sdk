//[Volyum](../../../index.md)/[ke.don.volyum.feedback.model.domain](../index.md)/[TimeFormatter](index.md)

# TimeFormatter

[common]\
object [TimeFormatter](index.md)

An object that provides utility functions for formatting time.

## Properties

| Name | Summary |
|---|---|
| [log](log.md) | [common]<br>val [log](log.md): Logger<br>Logger instance for the TimeFormatter object. Used for logging messages, errors, and debugging information related to time formatting. |

## Functions

| Name | Summary |
|---|---|
| [formatRelativeTime](format-relative-time.md) | [common]<br>fun [formatRelativeTime](format-relative-time.md)(timestamp: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), timeZone: TimeZone = TimeZone.currentSystemDefault()): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>Formats a timestamp string into a relative time string (e.g., &quot;Just now&quot;, &quot;5 minutes ago&quot;, &quot;Yesterday&quot;). |
| [plural](plural.md) | [common]<br>fun [plural](plural.md)(count: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), singular: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>Formats a count and a singular noun into a plural string, adding &quot;ago&quot;. |