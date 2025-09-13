//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[FeedbackItem](-feedback-item.md)

# FeedbackItem

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeedbackItem](-feedback-item.md)(item: Feedback, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, isPreview: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

Displays a single feedback item in a card format.

#### Parameters

common

| | |
|---|---|
| item | The Feedback object containing the data to display. |
| modifier | Optional [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) for this composable. |
| isPreview | If true, the feedback text will be truncated to a maximum of 4 lines.     If false, the full feedback text will be shown. |
| onClick | A lambda function to be invoked when the card is clicked. |