//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.config](../index.md)/[Volyum](index.md)/[sendFeedback](send-feedback.md)

# sendFeedback

[common]\
suspend fun [sendFeedback](send-feedback.md)(feedback: [Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md)): [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md)&lt;[Feedback](../../ke.don.volyum.feedback.model.table/-feedback/index.md), [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md)&gt;

Sends feedback to the Volyum API.

#### Return

A [VolyumResult](../../ke.don.volyum.feedback.model.domain/-volyum-result/index.md) containing the sent feedback or a [NetworkError](../../ke.don.volyum.feedback.model.domain/-network-error/index.md) if an error occurred.

#### Parameters

common

| | |
|---|---|
| feedback | The feedback to send. |