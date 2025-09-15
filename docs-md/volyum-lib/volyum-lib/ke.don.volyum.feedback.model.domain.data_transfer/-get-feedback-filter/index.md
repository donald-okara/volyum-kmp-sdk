//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.domain.data_transfer](../index.md)/[GetFeedbackFilter](index.md)

# GetFeedbackFilter

[common]\
data class [GetFeedbackFilter](index.md)(val limit: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, val offset: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, val userId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val targetId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val targetType: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val status: [FeedbackStatus](../../ke.don.volyum.feedback.model.table/-feedback-status/index.md)? = null)

Data class representing the filter options for retrieving feedback.

## Constructors

| | |
|---|---|
| [GetFeedbackFilter](-get-feedback-filter.md) | [common]<br>constructor(limit: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, offset: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, userId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, targetId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, targetType: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, status: [FeedbackStatus](../../ke.don.volyum.feedback.model.table/-feedback-status/index.md)? = null) |

## Properties

| Name | Summary |
|---|---|
| [limit](limit.md) | [common]<br>val [limit](limit.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null<br>The maximum number of feedback items to retrieve. |
| [offset](offset.md) | [common]<br>val [offset](offset.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null<br>The number of feedback items to skip before starting to retrieve. |
| [status](status.md) | [common]<br>val [status](status.md): [FeedbackStatus](../../ke.don.volyum.feedback.model.table/-feedback-status/index.md)? = null<br>The status of the feedback (e.g., &quot;pending&quot;, &quot;resolved&quot;). |
| [targetId](target-id.md) | [common]<br>val [targetId](target-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The ID of the target entity for which the feedback was submitted. |
| [targetType](target-type.md) | [common]<br>val [targetType](target-type.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The type of the target entity (e.g., &quot;product&quot;, &quot;service&quot;). |
| [userId](user-id.md) | [common]<br>val [userId](user-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The ID of the user who submitted the feedback. |