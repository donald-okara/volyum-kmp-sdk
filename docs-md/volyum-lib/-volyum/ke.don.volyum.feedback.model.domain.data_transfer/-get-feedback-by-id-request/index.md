//[Volyum](../../../index.md)/[ke.don.volyum.feedback.model.domain.data_transfer](../index.md)/[GetFeedbackByIdRequest](index.md)

# GetFeedbackByIdRequest

[common]\
@Serializable

data class [GetFeedbackByIdRequest](index.md)(val projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val apiKey: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val feedbackId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))

Represents the request to get feedback by its ID.

## Constructors

| | |
|---|---|
| [GetFeedbackByIdRequest](-get-feedback-by-id-request.md) | [common]<br>constructor(projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), apiKey: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), feedbackId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [apiKey](api-key.md) | [common]<br>@SerialName(value = &quot;api_key&quot;)<br>val [apiKey](api-key.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The API key for authentication. |
| [feedbackId](feedback-id.md) | [common]<br>@SerialName(value = &quot;feedback_id&quot;)<br>val [feedbackId](feedback-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The ID of the feedback to retrieve. |
| [projectId](project-id.md) | [common]<br>@SerialName(value = &quot;project_id&quot;)<br>val [projectId](project-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The ID of the project. |