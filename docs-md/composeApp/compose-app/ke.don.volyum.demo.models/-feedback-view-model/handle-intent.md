//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[FeedbackViewModel](index.md)/[handleIntent](handle-intent.md)

# handleIntent

[common]\
fun [handleIntent](handle-intent.md)(intent: [DemoIntentHandler](../-demo-intent-handler/index.md))

Handles incoming intents and updates the UI state accordingly.

This function processes different types of [DemoIntentHandler](../-demo-intent-handler/index.md) actions:

- 
   [DemoIntentHandler.GetFeedback](../-demo-intent-handler/-get-feedback/index.md): Triggers fetching the list of feedback.
- 
   [DemoIntentHandler.GetFeedbackById](../-demo-intent-handler/-get-feedback-by-id/index.md): Triggers fetching a specific feedback item by its ID.
- 
   [DemoIntentHandler.SendFeedback](../-demo-intent-handler/-send-feedback/index.md): Triggers sending new feedback.
- 
   [DemoIntentHandler.UpdateTargetType](../-demo-intent-handler/-update-target-type/index.md): Updates the target type for new feedback.
- 
   [DemoIntentHandler.UpdateFeedback](../-demo-intent-handler/-update-feedback/index.md): Updates the content of the feedback being composed.
- 
   [DemoIntentHandler.UpdateSender](../-demo-intent-handler/-update-sender/index.md): Updates the sender information for new feedback.
- 
   [DemoIntentHandler.ShowDetails](../-demo-intent-handler/-show-details/index.md): Toggles the visibility of the feedback details view.
- 
   [DemoIntentHandler.ShowForm](../-demo-intent-handler/-show-form/index.md): Toggles the visibility of the feedback submission form.
- 
   [DemoIntentHandler.UpdateFilter](../-demo-intent-handler/-update-filter/index.md): Updates the filter criteria for fetching feedback.

#### Parameters

common

| | |
|---|---|
| intent | The [DemoIntentHandler](../-demo-intent-handler/index.md) representing the user's action or a system event. |