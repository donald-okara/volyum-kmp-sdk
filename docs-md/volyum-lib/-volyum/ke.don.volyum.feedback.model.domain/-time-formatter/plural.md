//[Volyum](../../../index.md)/[ke.don.volyum.feedback.model.domain](../index.md)/[TimeFormatter](index.md)/[plural](plural.md)

# plural

[common]\
fun [plural](plural.md)(count: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), singular: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)

Formats a count and a singular noun into a plural string, adding &quot;ago&quot;.

For example, `plural(1, "minute")` returns &quot;1 minute ago&quot;, and `plural(2, "minute")` returns &quot;2 minutes ago&quot;.

#### Return

A string representing the pluralized count and noun, followed by &quot;ago&quot;.

#### Parameters

common

| | |
|---|---|
| count | The number of items. |
| singular | The singular form of the noun. |