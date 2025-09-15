//[Volyum](../../../index.md)/[ke.don.volyum.feedback.model.domain.data_transfer](../index.md)/[AddFeedbackRequest](index.md)

# AddFeedbackRequest

[common]\
@Serializable

data class [AddFeedbackRequest](index.md)(val projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val feedback: [Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md))

Data class representing the request to add feedback.

## Constructors

| | |
|---|---|
| [AddFeedbackRequest](-add-feedback-request.md) | [common]<br>constructor(projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), feedback: [Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [feedback](feedback.md) | [common]<br>@SerialName(value = &quot;feedback&quot;)<br>val [feedback](feedback.md): [Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md)<br>The feedback object containing the feedback details. |
| [key](key.md) | [common]<br>@SerialName(value = &quot;api_key&quot;)<br>val [key](key.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The API key for authorizing the request. |
| [projectId](project-id.md) | [common]<br>@SerialName(value = &quot;project_id&quot;)<br>val [projectId](project-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The unique identifier of the project to which the feedback belongs. |