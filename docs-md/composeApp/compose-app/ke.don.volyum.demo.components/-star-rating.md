//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[StarRating](-star-rating.md)

# StarRating

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [StarRating](-star-rating.md)(rating: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, starSize: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 20.dp, spacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 2.dp)

A composable function that displays a star rating.

#### Parameters

common

| | |
|---|---|
| rating | The current rating, an integer between 0 and 5. |
| modifier | Optional [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) for this composable. |
| starSize | The size of each star icon. Defaults to 20.dp. |
| spacing | The spacing between each star icon. Defaults to 2.dp. |