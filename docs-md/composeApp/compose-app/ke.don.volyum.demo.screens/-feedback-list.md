//[composeApp](../../index.md)/[ke.don.volyum.demo.screens](index.md)/[FeedbackList](-feedback-list.md)

# FeedbackList

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeedbackList](-feedback-list.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, state: [FeedbackState](../ke.don.volyum.demo.models/-feedback-state/index.md), handleIntent: ([DemoIntentHandler](../ke.don.volyum.demo.models/-demo-intent-handler/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Displays a list of feedback items with filtering and loading states.

#### Parameters

common

| | |
|---|---|
| modifier | Modifier for customizing the layout. |
| state | The current state of the feedback list, including loading status, error messages, and the list of feedback items. |
| handleIntent | A function to handle user intents, such as updating filters or fetching feedback. |