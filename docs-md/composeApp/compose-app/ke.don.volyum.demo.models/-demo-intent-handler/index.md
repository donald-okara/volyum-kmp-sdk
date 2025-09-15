//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[DemoIntentHandler](index.md)

# DemoIntentHandler

sealed class [DemoIntentHandler](index.md)

Represents the different intents or actions that can be performed in the demo application. These intents are used to communicate user actions or system events to the appropriate handlers.

#### Inheritors

| |
|---|
| [GetFeedback](-get-feedback/index.md) |
| [GetFeedbackById](-get-feedback-by-id/index.md) |
| [UpdateFeedback](-update-feedback/index.md) |
| [UpdateTargetType](-update-target-type/index.md) |
| [UpdateSender](-update-sender/index.md) |
| [UpdateFilter](-update-filter/index.md) |
| [SendFeedback](-send-feedback/index.md) |
| [ShowDetails](-show-details/index.md) |
| [ShowForm](-show-form/index.md) |

## Types

| Name | Summary |
|---|---|
| [GetFeedback](-get-feedback/index.md) | [common]<br>data class [GetFeedback](-get-feedback/index.md)(val filter: GetFeedbackFilter) : [DemoIntentHandler](index.md)<br>Represents an intent to get feedback based on a filter. |
| [GetFeedbackById](-get-feedback-by-id/index.md) | [common]<br>data class [GetFeedbackById](-get-feedback-by-id/index.md)(val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) : [DemoIntentHandler](index.md)<br>Represents an intent to retrieve a specific feedback entry by its unique identifier. |
| [SendFeedback](-send-feedback/index.md) | [common]<br>data object [SendFeedback](-send-feedback/index.md) : [DemoIntentHandler](index.md)<br>Represents an intent to send feedback. This intent handler is responsible for triggering the feedback sending process. |
| [ShowDetails](-show-details/index.md) | [common]<br>data object [ShowDetails](-show-details/index.md) : [DemoIntentHandler](index.md)<br>Intent to show the details screen. |
| [ShowForm](-show-form/index.md) | [common]<br>data object [ShowForm](-show-form/index.md) : [DemoIntentHandler](index.md)<br>An intent handler that signals the UI to show the feedback form. |
| [UpdateFeedback](-update-feedback/index.md) | [common]<br>data class [UpdateFeedback](-update-feedback/index.md)(val feedback: Feedback) : [DemoIntentHandler](index.md)<br>Represents an intent to update an existing feedback. |
| [UpdateFilter](-update-filter/index.md) | [common]<br>data class [UpdateFilter](-update-filter/index.md)(val filter: GetFeedbackFilter) : [DemoIntentHandler](index.md)<br>Represents an intent to update the feedback filter. |
| [UpdateSender](-update-sender/index.md) | [common]<br>data class [UpdateSender](-update-sender/index.md)(val sender: [UserSubmitOption](../-user-submit-option/index.md)) : [DemoIntentHandler](index.md)<br>Represents an intent to update the sender of the feedback. |
| [UpdateTargetType](-update-target-type/index.md) | [common]<br>data class [UpdateTargetType](-update-target-type/index.md)(val targetType: [EventFeature](../-event-feature/index.md)) : [DemoIntentHandler](index.md)<br>Represents an intent to update the target type for feedback. |