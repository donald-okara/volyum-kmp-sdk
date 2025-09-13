//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[shimmerBackground](shimmer-background.md)

# shimmerBackground

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html).[shimmerBackground](shimmer-background.md)(shape: [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) = RectangleShape, shimmerColors: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)&gt; = listOf(
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f),
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
    ), durationMillis: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 1200, shimmerWidth: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) = 500.0f): [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html)

A [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) that adds a shimmer effect to the background of a Composable.

This modifier creates a shimmering animation that can be used to indicate loading or an active state. The shimmer effect is achieved by animating a horizontal gradient across the Composable.

#### Return

A [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) that applies the shimmer background effect.

#### Parameters

common

| | |
|---|---|
| shape | The [Shape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shape.html) of the background to apply the shimmer to. Defaults to [RectangleShape](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/package-summary.html). |
| shimmerColors | A [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html) of [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)s to use for the shimmer gradient.     Defaults to a list of three colors derived from `MaterialTheme.colorScheme.surfaceVariant`     with varying alpha values to create a subtle shimmer. |
| durationMillis | The duration of one shimmer animation cycle in milliseconds. Defaults to `1200`. |
| shimmerWidth | The width of the shimmering gradient in pixels. Defaults to `500f`. |