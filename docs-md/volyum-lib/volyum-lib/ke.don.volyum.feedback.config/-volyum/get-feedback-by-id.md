//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.config](../index.md)/[Volyum](index.md)/[getFeedbackById](get-feedback-by-id.md)

# getFeedbackById

[common]\
suspend fun [getFeedbackById](get-feedback-by-id.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md)&lt;[Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md), [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md)&gt;

Retrieves a feedback item by its unique identifier.

This function makes an API call to fetch a specific feedback item based on the provided ID.

#### Return

A [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md) which is either a [VolyumResult.Success](../../ke.don.volyum.feedback.model.domain/-volyum-result/-success/index.md) containing the [Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md) object     or a [VolyumResult.Error](../../ke.don.volyum.feedback.model.domain/-volyum-result/-error/index.md) containing a [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md) if the request fails.

#### Parameters

common

| | |
|---|---|
| id | The unique identifier of the feedback to retrieve. |