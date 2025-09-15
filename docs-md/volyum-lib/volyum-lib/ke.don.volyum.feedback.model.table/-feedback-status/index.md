//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.table](../index.md)/[FeedbackStatus](index.md)

# FeedbackStatus

[common]\
@Serializable

enum [FeedbackStatus](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[FeedbackStatus](index.md)&gt; 

Represents the status of a feedback item.

This enum class is used to track the progress of a feedback item through its lifecycle. The possible statuses are:

- 
   **Pending**: The feedback item has been submitted but not yet reviewed.
- 
   **Reviewed**: The feedback item has been reviewed by an administrator.
- 
   **Resolved**: The feedback item has been addressed and the issue is considered resolved.
- 
   **Rejected**: The feedback item has been reviewed and rejected.

## Entries

| | |
|---|---|
| [Pending](-pending/index.md) | [common]<br>@SerialName(value = &quot;pending&quot;)<br>[Pending](-pending/index.md) |
| [Reviewed](-reviewed/index.md) | [common]<br>@SerialName(value = &quot;reviewed&quot;)<br>[Reviewed](-reviewed/index.md) |
| [Resolved](-resolved/index.md) | [common]<br>@SerialName(value = &quot;resolved&quot;)<br>[Resolved](-resolved/index.md) |
| [Rejected](-rejected/index.md) | [common]<br>@SerialName(value = &quot;rejected&quot;)<br>[Rejected](-rejected/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [common]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[FeedbackStatus](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](-rejected/index.md#-372974862%2FProperties%2F-1200628132) | [common]<br>val [name](-rejected/index.md#-372974862%2FProperties%2F-1200628132): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [ordinal](-rejected/index.md#-739389684%2FProperties%2F-1200628132) | [common]<br>val [ordinal](-rejected/index.md#-739389684%2FProperties%2F-1200628132): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [FeedbackStatus](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[FeedbackStatus](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |