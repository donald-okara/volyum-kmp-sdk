//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[FeedbackViewModel](index.md)/[updateFilter](update-filter.md)

# updateFilter

[common]\
fun [updateFilter](update-filter.md)(filter: GetFeedbackFilter)

Updates the filter for retrieving feedback.

This function updates the current state with the new filter and then triggers a call to [getFeedback](get-feedback.md) to fetch feedback based on the updated filter.

#### Parameters

common

| | |
|---|---|
| filter | The GetFeedbackFilter to apply. |