//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[EmptyScreenMessage](-empty-screen-message.md)

# EmptyScreenMessage

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [EmptyScreenMessage](-empty-screen-message.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, icon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html) = Icons.Default.Info, title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, actionLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, onActionClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null)

A composable function that displays a message for an empty screen.

This function is typically used when a screen has no content to display, such as when a list is empty or when there is an error fetching data.

#### Parameters

common

| | |
|---|---|
| modifier | The modifier to be applied to the layout. |
| icon | The icon to be displayed. Defaults to Icons.Default.Info. |
| title | The title of the message. |
| message | An optional message to provide more details. |
| actionLabel | An optional label for an action button. |
| onActionClick | An optional lambda to be executed when the action button is clicked. |