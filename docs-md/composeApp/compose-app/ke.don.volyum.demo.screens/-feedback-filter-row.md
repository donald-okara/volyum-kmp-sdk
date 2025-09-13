//[composeApp](../../index.md)/[ke.don.volyum.demo.screens](index.md)/[FeedbackFilterRow](-feedback-filter-row.md)

# FeedbackFilterRow

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [FeedbackFilterRow](-feedback-filter-row.md)(myUserData: [UserData](../ke.don.volyum.demo.models/-user-data/index.md)? = null, filter: GetFeedbackFilter, showForm: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onShowFormChange: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onFilterChange: (GetFeedbackFilter) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)

Composable function that displays a row of filter chips for feedback.

#### Parameters

common

| | |
|---|---|
| myUserData | The current user's data, used to filter by &quot;Just mine&quot;. |
| filter | The current feedback filter. |
| showForm | Whether the new feedback form is shown. |
| onShowFormChange | Callback triggered when the &quot;New Feedback&quot; chip is clicked. |
| onFilterChange | Callback triggered when a filter chip is clicked or a dropdown option is selected. |
| modifier | Modifier for this composable. |