//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[FeedbackViewModel](index.md)/[getFeedbackById](get-feedback-by-id.md)

# getFeedbackById

[common]\
fun [getFeedbackById](get-feedback-by-id.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))

Retrieves a feedback entry by its unique identifier.

This function initiates an asynchronous operation to fetch a specific feedback entry. It updates the UI state to indicate that data is being loaded and that the details view should be shown.

On successful retrieval, the UI state is updated with the fetched feedback data and the loading indicator is turned off.

In case of an error, the `handleError` function is called to manage the error, providing a retry mechanism and updating the UI state to reflect the error.

#### Parameters

common

| | |
|---|---|
| id | The unique identifier of the feedback entry to retrieve. |