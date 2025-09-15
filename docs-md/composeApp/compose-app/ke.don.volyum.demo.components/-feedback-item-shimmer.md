//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[FeedbackItemShimmer](-feedback-item-shimmer.md)

# FeedbackItemShimmer

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeedbackItemShimmer](-feedback-item-shimmer.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)

A composable function that displays a shimmer loading placeholder for a feedback item. This is typically used while the actual feedback data is being fetched.

The shimmer effect is achieved by using the `shimmerBackground` modifier on various Box elements that represent the different parts of a feedback item (avatar, name, rating, text, etc.).

#### Parameters

common

| | |
|---|---|
| modifier | Optional [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) to be applied to the root OutlinedCard of the shimmer item. |