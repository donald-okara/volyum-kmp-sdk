//[composeApp](../../index.md)/[ke.don.volyum.demo.screens](index.md)/[FeedbackForm](-feedback-form.md)

# FeedbackForm

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeedbackForm](-feedback-form.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, state: [FeedbackState](../ke.don.volyum.demo.models/-feedback-state/index.md), onEvent: ([DemoIntentHandler](../ke.don.volyum.demo.models/-demo-intent-handler/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Composable function for the feedback form.

This function displays a form with various input fields for users to provide feedback.

#### Parameters

common

| | |
|---|---|
| modifier | Modifier for customizing the layout and appearance of the form. |
| state | The current state of the feedback form, containing data like rating, text, and loading status. |
| onEvent | A callback function to handle user interactions and events within the form. |