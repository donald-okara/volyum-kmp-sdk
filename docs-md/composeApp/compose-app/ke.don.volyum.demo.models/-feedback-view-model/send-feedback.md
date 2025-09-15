//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[FeedbackViewModel](index.md)/[sendFeedback](send-feedback.md)

# sendFeedback

[common]\
fun [sendFeedback](send-feedback.md)()

Sends feedback to the server. It first determines the user data based on the selected sender option (MyProfile, Anonymous, or RandomUser). Then, it launches a coroutine to update the UI state to indicate that the feedback sending process is in progress. It calls the `volyum.sendFeedback` function with the feedback data, including the user ID, target type, and user metadata. If the feedback is sent successfully, it calls `getFeedback()` to refresh the feedback list and updates the UI state to indicate that the sending process is complete. If an error occurs during the sending process, it calls `handleError` to display an error message and provide a retry option.