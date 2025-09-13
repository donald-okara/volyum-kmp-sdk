//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[FeedbackViewModel](index.md)

# FeedbackViewModel

[common]\
class [FeedbackViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for managing feedback-related data and actions.

This ViewModel interacts with the Volyum SDK to fetch, send, and manage feedback. It exposes UI state through a StateFlow and handles user intents to update the state and perform actions.

## Constructors

| | |
|---|---|
| [FeedbackViewModel](-feedback-view-model.md) | [common]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [uiState](ui-state.md) | [common]<br>val [uiState](ui-state.md): StateFlow&lt;[FeedbackState](../-feedback-state/index.md)&gt;<br>The current state of the feedback UI. This StateFlow emits updates to the UI whenever the feedback state changes. |
| [volyum](volyum.md) | [common]<br>val [volyum](volyum.md): Volyum<br>Instance of the Volyum SDK. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#2068605057%2FFunctions%2F-1518758877) | [common]<br>expect open fun [addCloseable](index.md#2068605057%2FFunctions%2F-1518758877)(closeable: [AutoCloseable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-auto-closeable/index.html))<br>expect fun [addCloseable](index.md#2093014716%2FFunctions%2F-1518758877)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), closeable: [AutoCloseable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-auto-closeable/index.html)) |
| [getCloseable](index.md#1102255800%2FFunctions%2F-1518758877) | [common]<br>expect fun &lt;[T](index.md#1102255800%2FFunctions%2F-1518758877) : [AutoCloseable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-auto-closeable/index.html)&gt; [getCloseable](index.md#1102255800%2FFunctions%2F-1518758877)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [T](index.md#1102255800%2FFunctions%2F-1518758877)? |
| [getFeedback](get-feedback.md) | [common]<br>fun [getFeedback](get-feedback.md)()<br>Fetches a list of feedback items from the Volyum SDK based on the current filter settings. |
| [getFeedbackById](get-feedback-by-id.md) | [common]<br>fun [getFeedbackById](get-feedback-by-id.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Retrieves a feedback entry by its unique identifier. |
| [handleIntent](handle-intent.md) | [common]<br>fun [handleIntent](handle-intent.md)(intent: [DemoIntentHandler](../-demo-intent-handler/index.md))<br>Handles incoming intents and updates the UI state accordingly. |
| [sendFeedback](send-feedback.md) | [common]<br>fun [sendFeedback](send-feedback.md)()<br>Sends feedback to the server. It first determines the user data based on the selected sender option (MyProfile, Anonymous, or RandomUser). Then, it launches a coroutine to update the UI state to indicate that the feedback sending process is in progress. It calls the `volyum.sendFeedback` function with the feedback data, including the user ID, target type, and user metadata. If the feedback is sent successfully, it calls `getFeedback()` to refresh the feedback list and updates the UI state to indicate that the sending process is complete. If an error occurs during the sending process, it calls `handleError` to display an error message and provide a retry option. |
| [updateFeedback](update-feedback.md) | [common]<br>fun [updateFeedback](update-feedback.md)(feedback: Feedback)<br>Updates the feedback object in the UI state. This is typically used to update the feedback form before sending it. |
| [updateFilter](update-filter.md) | [common]<br>fun [updateFilter](update-filter.md)(filter: GetFeedbackFilter)<br>Updates the filter for retrieving feedback. |
| [updateState](update-state.md) | [common]<br>fun [updateState](update-state.md)(transform: ([FeedbackState](../-feedback-state/index.md)) -&gt; [FeedbackState](../-feedback-state/index.md))<br>Updates the UI state by applying the given transformation function. |