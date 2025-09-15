//[composeApp](../../index.md)/[ke.don.volyum.demo.screens](index.md)/[FeatureDropdown](-feature-dropdown.md)

# FeatureDropdown

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeatureDropdown](-feature-dropdown.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, selected: [EventFeature](../ke.don.volyum.demo.models/-event-feature/index.md), onFeatureSelected: ([EventFeature](../ke.don.volyum.demo.models/-event-feature/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A dropdown menu for selecting a product feature.

#### Parameters

common

| | |
|---|---|
| modifier | The modifier to apply to this layout. |
| selected | The currently selected feature. |
| onFeatureSelected | A callback that is invoked when a feature is selected. |