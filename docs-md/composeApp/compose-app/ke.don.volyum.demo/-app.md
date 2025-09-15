//[composeApp](../../index.md)/[ke.don.volyum.demo](index.md)/[App](-app.md)

# App

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

@Preview

fun [App](-app.md)()

Main application composable function. Sets up the theme, view model, state, and KoffeeBar for displaying toasts. It also launches an effect to fetch initial feedback data. The UI is rendered within a [Surface](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary.html) and KoffeeBar, with the main content provided by [FeedbackScreenContent](-feedback-screen-content.md).