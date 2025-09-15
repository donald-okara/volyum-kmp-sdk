//[composeApp](../../index.md)/[ke.don.volyum.demo.screens](index.md)/[FeedbackDetailsScreen](-feedback-details-screen.md)

# FeedbackDetailsScreen

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeedbackDetailsScreen](-feedback-details-screen.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, state: [FeedbackState](../ke.don.volyum.demo.models/-feedback-state/index.md) = FeedbackState(), handleIntent: ([DemoIntentHandler](../ke.don.volyum.demo.models/-demo-intent-handler/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Composable function that displays the details of a feedback item.

This screen shows the feedback item itself and any closing remarks. It also handles loading and error states. A dismiss button is provided to close the details view.

#### Parameters

common

| | |
|---|---|
| modifier | Modifier for this composable. |
| state | The current state of the feedback details, containing information like loading status, error messages, and the feedback item itself. |
| handleIntent | A lambda function to handle user intents, specifically to dismiss the details view. |