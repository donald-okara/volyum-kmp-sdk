//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[RatingInput](-rating-input.md)

# RatingInput

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [RatingInput](-rating-input.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, rating: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), onRatingChange: (rating: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A composable function that displays a row of 5 stars for rating input.

#### Parameters

common

| | |
|---|---|
| modifier | The modifier to apply to this layout. |
| rating | The current rating value, an integer from 1 to 5. |
| onRatingChange | A callback function that is invoked when the rating changes.     It receives the new rating value as an argument. |