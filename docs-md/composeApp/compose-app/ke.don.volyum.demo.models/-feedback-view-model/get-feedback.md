//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[FeedbackViewModel](index.md)/[getFeedback](get-feedback.md)

# getFeedback

[common]\
fun [getFeedback](get-feedback.md)()

Fetches a list of feedback items from the Volyum SDK based on the current filter settings.

This function initiates an asynchronous operation within the `viewModelScope`. It first updates the UI state to indicate that the list is loading. Then, it calls the `volyum.getFeedback()` method with the current filter from `uiState`.

On successful retrieval of feedback:

- 
   The UI state is updated with the fetched feedback list.
- 
   The `listIsLoading` flag is set to `false`.

On error during feedback retrieval:

- 
   The `handleError` function is called to manage the error.
- 
   `handleError` will update the UI state to reflect the error (setting `listIsLoading` to `false`, `listIsError` to `true`, and providing an error message).
- 
   `handleError` also provides a retry mechanism by passing this `getFeedback()` function itself.