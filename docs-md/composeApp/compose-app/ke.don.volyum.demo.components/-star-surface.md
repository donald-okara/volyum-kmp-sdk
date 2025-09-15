//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[StarSurface](-star-surface.md)

# StarSurface

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [StarSurface](-star-surface.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, size: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 40.dp, index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null, onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), filled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html))

Composable function that displays a star icon, which can be either filled or outlined, typically used for rating systems.

#### Parameters

common

| | |
|---|---|
| modifier | The modifier to be applied to the component. |
| size | The size of the star icon. Defaults to 40.dp. |
| index | The index of the star, used for content description when part of a rating system.     If null, a generic &quot;Star Icon&quot; content description is used. |
| onClick | Lambda function to be invoked when the star is clicked. |
| filled | A boolean indicating whether the star should be filled (true) or outlined (false). |