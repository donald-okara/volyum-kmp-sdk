//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.domain.data_transfer](../index.md)/[GetFeedbackRequest](index.md)

# GetFeedbackRequest

[common]\
@Serializable

data class [GetFeedbackRequest](index.md)(val projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val apiKey: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val userId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val targetId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val targetType: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val status: [FeedbackStatus](../../ke.don.volyum.feedback.model.table/-feedback-status/index.md)? = null, val limit: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, val offset: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null)

Represents a request to retrieve feedback.

## Constructors

| | |
|---|---|
| [GetFeedbackRequest](-get-feedback-request.md) | [common]<br>constructor(projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), apiKey: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), userId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, targetId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, targetType: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, status: [FeedbackStatus](../../ke.don.volyum.feedback.model.table/-feedback-status/index.md)? = null, limit: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, offset: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [apiKey](api-key.md) | [common]<br>@SerialName(value = &quot;api_key&quot;)<br>val [apiKey](api-key.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The API key for authentication. |
| [limit](limit.md) | [common]<br>val [limit](limit.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null<br>The maximum number of feedback items to retrieve (optional). |
| [offset](offset.md) | [common]<br>val [offset](offset.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null<br>The offset for pagination (optional). |
| [projectId](project-id.md) | [common]<br>@SerialName(value = &quot;project_id&quot;)<br>val [projectId](project-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The ID of the project. |
| [status](status.md) | [common]<br>val [status](status.md): [FeedbackStatus](../../ke.don.volyum.feedback.model.table/-feedback-status/index.md)? = null<br>The status of the feedback (optional). |
| [targetId](target-id.md) | [common]<br>@SerialName(value = &quot;target_id&quot;)<br>val [targetId](target-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The ID of the target (optional). |
| [targetType](target-type.md) | [common]<br>@SerialName(value = &quot;target_type&quot;)<br>val [targetType](target-type.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The type of the target (optional). |
| [userId](user-id.md) | [common]<br>@SerialName(value = &quot;user_id&quot;)<br>val [userId](user-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The ID of the user (optional). |