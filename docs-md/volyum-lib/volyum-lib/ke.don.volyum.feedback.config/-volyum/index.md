//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.config](../index.md)/[Volyum](index.md)

# Volyum

[common]\
class [Volyum](index.md)

The main entry point for interacting with the Volyum feedback system. This class provides methods for sending, retrieving, and managing feedback.

It is constructed internally and accessed via the `VolyumFactory.create()` method.

## Functions

| Name | Summary |
|---|---|
| [getFeedback](get-feedback.md) | [common]<br>suspend fun [getFeedback](get-feedback.md)(filter: [GetFeedbackFilter](../../ke.don.volyum.feedback.model.domain.data_transfer/-get-feedback-filter/index.md)): [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md)&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md)&gt;, [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md)&gt;<br>Retrieves a list of feedback entries based on the provided filter. |
| [getFeedbackById](get-feedback-by-id.md) | [common]<br>suspend fun [getFeedbackById](get-feedback-by-id.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md)&lt;[Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md), [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md)&gt;<br>Retrieves a feedback item by its unique identifier. |
| [sendFeedback](send-feedback.md) | [common]<br>suspend fun [sendFeedback](send-feedback.md)(feedback: [Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md)): [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md)&lt;[Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md), [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md)&gt;<br>Sends feedback to the Volyum API. |