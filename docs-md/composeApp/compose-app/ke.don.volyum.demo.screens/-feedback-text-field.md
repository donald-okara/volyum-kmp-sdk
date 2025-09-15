//[composeApp](../../index.md)/[ke.don.volyum.demo.screens](index.md)/[FeedbackTextField](-feedback-text-field.md)

# FeedbackTextField

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeedbackTextField](-feedback-text-field.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), onTextChange: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), minLines: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 5, maxChars: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 500)

A Composable function that creates a text field for user feedback.

This text field is designed for multi-line input, includes a character counter, and allows customization of minimum lines and maximum characters.

#### Parameters

common

| | |
|---|---|
| modifier | Optional [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) for styling and layout. |
| text | The current text content of the feedback field. |
| onTextChange | A lambda function called when the text in the field changes.     It receives the new text as a String. |
| minLines | The minimum number of lines the text field should display by default.     Defaults to 5. |
| maxChars | The maximum number of characters allowed in the feedback field.     Defaults to 500. |