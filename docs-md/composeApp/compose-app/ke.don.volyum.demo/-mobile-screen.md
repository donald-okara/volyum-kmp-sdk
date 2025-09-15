//[composeApp](../../index.md)/[ke.don.volyum.demo](index.md)/[MobileScreen](-mobile-screen.md)

# MobileScreen

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [MobileScreen](-mobile-screen.md)(state: [FeedbackState](../ke.don.volyum.demo.models/-feedback-state/index.md), handleIntent: ([DemoIntentHandler](../ke.don.volyum.demo.models/-demo-intent-handler/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Composable function for the mobile screen layout. It displays the feedback list and uses modal bottom sheets for details and form.

#### Parameters

common

| | |
|---|---|
| state | The current state of the feedback screen. |
| handleIntent | A function to handle user intents. |