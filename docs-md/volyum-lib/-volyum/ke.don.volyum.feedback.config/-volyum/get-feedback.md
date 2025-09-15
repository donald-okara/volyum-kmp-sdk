//[Volyum](../../../index.md)/[ke.don.volyum.feedback.config](../index.md)/[Volyum](index.md)/[getFeedback](get-feedback.md)

# getFeedback

[common]\
suspend fun [getFeedback](get-feedback.md)(filter: [GetFeedbackFilter](../../ke.don.volyum.feedback.model.domain.data_transfer/-get-feedback-filter/index.md)): [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md)&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md)&gt;, [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md)&gt;

Retrieves a list of feedback entries based on the provided filter.

This function makes an API call to fetch feedback. The results can be filtered using the [GetFeedbackFilter](../../ke.don.volyum.feedback.model.domain.data_transfer/-get-feedback-filter/index.md) object.

#### Return

A [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md) which is either a [VolyumResult.Success](../../ke.don.volyum.feedback.model.domain/-volyum-result/-success/index.md) containing a list of [Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md) objects     or a [VolyumResult.Error](../../ke.don.volyum.feedback.model.domain/-volyum-result/-error/index.md) containing a [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md) if the request fails.

#### Parameters

common

| | |
|---|---|
| filter | The filter criteria to apply when fetching feedback. |