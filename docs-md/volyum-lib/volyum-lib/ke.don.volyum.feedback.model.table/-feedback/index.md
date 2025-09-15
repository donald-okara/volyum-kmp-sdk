//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.table](../index.md)/[Feedback](index.md)

# Feedback

[common]\
@Serializable

data class [Feedback](index.md)(val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val userId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val targetId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val targetType: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val createdAt: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, val closingRemarks: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val userMetadata: [UserMetadata](../-user-metadata/index.md)? = UserMetadata(), val text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = &quot;&quot;, val rating: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, val status: [FeedbackStatus](../-feedback-status/index.md) = FeedbackStatus.Pending)

Represents a feedback entry.

## Constructors

| | |
|---|---|
| [Feedback](-feedback.md) | [common]<br>constructor(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, userId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, targetId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, targetType: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, createdAt: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, closingRemarks: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, userMetadata: [UserMetadata](../-user-metadata/index.md)? = UserMetadata(), text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = &quot;&quot;, rating: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, status: [FeedbackStatus](../-feedback-status/index.md) = FeedbackStatus.Pending) |

## Properties

| Name | Summary |
|---|---|
| [closingRemarks](closing-remarks.md) | [common]<br>@SerialName(value = &quot;closing_remarks&quot;)<br>val [closingRemarks](closing-remarks.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>Any closing remarks associated with the feedback. |
| [createdAt](created-at.md) | [common]<br>@SerialName(value = &quot;created_at&quot;)<br>val [createdAt](created-at.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The timestamp when the feedback was created. |
| [id](id.md) | [common]<br>val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The unique identifier of the feedback. |
| [rating](rating.md) | [common]<br>val [rating](rating.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null<br>The rating given by the user, if applicable (must be between 1 and 5). |
| [status](status.md) | [common]<br>val [status](status.md): [FeedbackStatus](../-feedback-status/index.md)<br>The current status of the feedback. |
| [targetId](target-id.md) | [common]<br>@SerialName(value = &quot;target_id&quot;)<br>val [targetId](target-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The ID of the target entity (e.g., product, service) the feedback is about. |
| [targetType](target-type.md) | [common]<br>@SerialName(value = &quot;target_type&quot;)<br>val [targetType](target-type.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The type of the target entity. |
| [text](text.md) | [common]<br>val [text](text.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>The main content of the feedback. |
| [userId](user-id.md) | [common]<br>@SerialName(value = &quot;user_id&quot;)<br>val [userId](user-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The ID of the user who submitted the feedback. |
| [userMetadata](user-metadata.md) | [common]<br>@SerialName(value = &quot;user_metadata&quot;)<br>val [userMetadata](user-metadata.md): [UserMetadata](../-user-metadata/index.md)?<br>Additional metadata about the user. |

## Functions

| Name | Summary |
|---|---|
| [formatTimestamp](format-timestamp.md) | [common]<br>fun [formatTimestamp](format-timestamp.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>Formats the `createdAt` timestamp into a human-readable relative time string. |