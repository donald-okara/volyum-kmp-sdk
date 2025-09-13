//[composeApp](../../index.md)/[ke.don.volyum.demo.screens](index.md)/[UserSubmitOptionSelector](-user-submit-option-selector.md)

# UserSubmitOptionSelector

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [UserSubmitOptionSelector](-user-submit-option-selector.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, selected: [UserSubmitOption](../ke.don.volyum.demo.models/-user-submit-option/index.md), onOptionSelected: ([UserSubmitOption](../ke.don.volyum.demo.models/-user-submit-option/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A composable function that displays a list of user submit options as radio buttons.

#### Parameters

common

| | |
|---|---|
| modifier | The modifier to be applied to the layout. |
| selected | The currently selected [UserSubmitOption](../ke.don.volyum.demo.models/-user-submit-option/index.md). |
| onOptionSelected | A callback function that is invoked when a user selects an option. |