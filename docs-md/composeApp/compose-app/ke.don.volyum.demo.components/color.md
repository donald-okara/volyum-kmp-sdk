//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[color](color.md)

# color

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun FeedbackStatus.[color](color.md)(): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)

Returns the color associated with the FeedbackStatus.

This Composable function maps each FeedbackStatus to a specific color from the current [MaterialTheme.colorScheme](https://developer.android.com/reference/kotlin/androidx/compose/material3/MaterialTheme.html#colorScheme--).

#### Return

The [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) corresponding to the feedback status:

- 
   FeedbackStatus.Pending ->`MaterialTheme.colorScheme.primary`
- 
   FeedbackStatus.Reviewed ->`MaterialTheme.colorScheme.tertiary`
- 
   FeedbackStatus.Resolved ->`MaterialTheme.colorScheme.secondary`
- 
   FeedbackStatus.Rejected ->`MaterialTheme.colorScheme.error`