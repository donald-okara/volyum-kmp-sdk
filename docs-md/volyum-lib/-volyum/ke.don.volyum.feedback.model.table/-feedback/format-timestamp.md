//[Volyum](../../../index.md)/[ke.don.volyum.feedback.model.table](../index.md)/[Feedback](index.md)/[formatTimestamp](format-timestamp.md)

# formatTimestamp

[common]\
fun [formatTimestamp](format-timestamp.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)

Formats the `createdAt` timestamp into a human-readable relative time string.

For example, &quot;2 minutes ago&quot;, &quot;1 hour ago&quot;, &quot;yesterday&quot;.

#### Return

A formatted string representing the relative time since the feedback was created, or an empty string if `createdAt` is empty.