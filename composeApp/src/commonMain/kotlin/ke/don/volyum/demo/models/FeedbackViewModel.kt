/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.donald_okara.volyum.config.VolyumSdk
import io.github.donald_okara.volyum.model.domain.NetworkError
import io.github.donald_okara.volyum.model.domain.data_transfer.GetFeedbackFilter
import io.github.donald_okara.volyum.model.domain.onError
import io.github.donald_okara.volyum.model.domain.onSuccess
import io.github.donald_okara.volyum.model.table.Feedback
import io.github.donald_okara.volyum.model.table.UserMetadata
import ke.don.koffee.domain.Koffee
import ke.don.koffee.model.ToastAction
import ke.don.koffee.model.ToastDuration
import ke.don.koffee.model.ToastType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ViewModel for managing feedback-related data and actions.
 *
 * This ViewModel interacts with the Volyum SDK to fetch, send, and manage feedback.
 * It exposes UI state through a [StateFlow] and handles user intents to update the state
 * and perform actions.
 */
class FeedbackViewModel : ViewModel() {
    /**
     * Instance of the Volyum SDK.
     */
    val volyum = VolyumSdk.get()

    /**
     * The mutable state flow that holds the current state of the feedback UI.
     * This is private to ensure that the state is only modified through the [updateState] function.
     */
    private val _uiState = MutableStateFlow(FeedbackState())

    /**
     * The current state of the feedback UI.
     * This StateFlow emits updates to the UI whenever the feedback state changes.
     */
    val uiState: StateFlow<FeedbackState> = _uiState

    /**
     * Updates the UI state by applying the given transformation function.
     *
     * @param transform The transformation function to apply to the current state.
     */
    fun updateState(transform: (FeedbackState) -> FeedbackState) {
        _uiState.update { state ->
            transform(state)
        }
    }

    /**
     * Handles incoming intents and updates the UI state accordingly.
     *
     * This function processes different types of [DemoIntentHandler] actions:
     * - [DemoIntentHandler.GetFeedback]: Triggers fetching the list of feedback.
     * - [DemoIntentHandler.GetFeedbackById]: Triggers fetching a specific feedback item by its ID.
     * - [DemoIntentHandler.SendFeedback]: Triggers sending new feedback.
     * - [DemoIntentHandler.UpdateTargetType]: Updates the target type for new feedback.
     * - [DemoIntentHandler.UpdateFeedback]: Updates the content of the feedback being composed.
     * - [DemoIntentHandler.UpdateSender]: Updates the sender information for new feedback.
     * - [DemoIntentHandler.ShowDetails]: Toggles the visibility of the feedback details view.
     * - [DemoIntentHandler.ShowForm]: Toggles the visibility of the feedback submission form.
     * - [DemoIntentHandler.UpdateFilter]: Updates the filter criteria for fetching feedback.
     *
     * @param intent The [DemoIntentHandler] representing the user's action or a system event.
     */
    fun handleIntent(intent: DemoIntentHandler) {
        when (intent) {
            is DemoIntentHandler.GetFeedback -> getFeedback()
            is DemoIntentHandler.GetFeedbackById -> getFeedbackById(intent.id)
            is DemoIntentHandler.SendFeedback -> sendFeedback()
            is DemoIntentHandler.UpdateTargetType -> updateState { state ->
                state.copy(targetType = intent.targetType)
            }
            is DemoIntentHandler.UpdateFeedback -> {
                updateFeedback(intent.feedback)
            }
            is DemoIntentHandler.UpdateSender -> {
                updateState { state ->
                    state.copy(sender = intent.sender)
                }
            }
            DemoIntentHandler.ShowDetails -> updateState { state ->
                state.copy(showDetails = !state.showDetails)
            }
            DemoIntentHandler.ShowForm -> updateState { state ->
                state.copy(showForm = !state.showForm)
            }
            is DemoIntentHandler.UpdateFilter -> {
                updateFilter(intent.filter)
            }
        }
    }

    /**
     * Fetches a list of feedback items from the Volyum SDK based on the current filter settings.
     *
     * This function initiates an asynchronous operation within the `viewModelScope`.
     * It first updates the UI state to indicate that the list is loading.
     * Then, it calls the `volyum.getFeedback()` method with the current filter from `uiState`.
     *
     * On successful retrieval of feedback:
     * - The UI state is updated with the fetched feedback list.
     * - The `listIsLoading` flag is set to `false`.
     *
     * On error during feedback retrieval:
     * - The `handleError` function is called to manage the error.
     * - `handleError` will update the UI state to reflect the error (setting `listIsLoading` to `false`,
     *   `listIsError` to `true`, and providing an error message).
     * - `handleError` also provides a retry mechanism by passing this `getFeedback()` function itself.
     */
    fun getFeedback() {
        viewModelScope.launch {
            updateState {
                it.copy(listIsLoading = true)
            }
            volyum.getFeedback(uiState.value.filter)
                .onSuccess {
                    updateState { state ->
                        state.copy(
                            feedbackList = it,
                            listIsLoading = false,
                        )
                    }
                }
                .onError {
                    handleError(
                        error = it,
                        onRetry = { getFeedback() },
                        updateState = { message ->
                            updateState { state ->
                                state.copy(
                                    listIsLoading = false,
                                    listIsError = true,
                                    listErrorMessage = message,
                                )
                            }
                        },

                    )
                }
        }
    }

    /**
     * Retrieves a feedback entry by its unique identifier.
     *
     * This function initiates an asynchronous operation to fetch a specific feedback entry.
     * It updates the UI state to indicate that data is being loaded and that the details
     * view should be shown.
     *
     * On successful retrieval, the UI state is updated with the fetched feedback data
     * and the loading indicator is turned off.
     *
     * In case of an error, the `handleError` function is called to manage the error,
     * providing a retry mechanism and updating the UI state to reflect the error.
     *
     * @param id The unique identifier of the feedback entry to retrieve.
     */
    fun getFeedbackById(id: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    readIsLoading = true,
                    showDetails = true,
                )
            }
            volyum.getFeedbackById(id).onSuccess {
                updateState { state ->
                    state.copy(
                        readFeedback = it,
                        readIsLoading = false,
                    )
                }
            }.onError {
                handleError(
                    error = it,
                    onRetry = { getFeedbackById(id) },
                    updateState = { message ->
                        updateState { state ->
                            state.copy(
                                readIsLoading = false,
                                readIsError = true,
                                readErrorMessage = message,
                            )
                        }
                    },
                )
            }
        }
    }

    /**
     * Sends feedback to the server.
     * It first determines the user data based on the selected sender option (MyProfile, Anonymous, or RandomUser).
     * Then, it launches a coroutine to update the UI state to indicate that the feedback sending process is in progress.
     * It calls the `volyum.sendFeedback` function with the feedback data, including the user ID, target type, and user metadata.
     * If the feedback is sent successfully, it calls `getFeedback()` to refresh the feedback list and updates the UI state to indicate that the sending process is complete.
     * If an error occurs during the sending process, it calls `handleError` to display an error message and provide a retry option.
     */
    fun sendFeedback() {
        val userData = when (uiState.value.sender) {
            UserSubmitOption.MyProfile -> uiState.value.myUserData
            UserSubmitOption.Anonymous -> null
            UserSubmitOption.RandomUser -> UserData().getRandom()
        }
        viewModelScope.launch {
            updateState {
                it.copy(
                    sendIsLoading = true,
                )
            }
            volyum.sendFeedback(
                uiState.value.sendFeedback.copy(
                    userId = userData?.id,
                    targetType = uiState.value.targetType.label,
                    userMetadata = UserMetadata(
                        username = userData?.name,
                        profileUrl = userData?.profileUrl,
                    ),
                ),
            ).onSuccess {
                getFeedback()
                updateState { state ->
                    state.copy(
                        sendIsLoading = false,
                    )
                }
            }.onError {
                handleError(
                    error = it,
                    onRetry = { sendFeedback() },
                    updateState = { message ->
                        updateState { state ->
                            state.copy(
                                sendIsLoading = false,
                                sendIsError = true,
                                sendErrorMessage = message,
                            )
                        }
                    },
                )
            }
        }
    }

    /**
     * Updates the feedback object in the UI state.
     * This is typically used to update the feedback form before sending it.
     *
     * @param feedback The [Feedback] object containing the new feedback data.
     */
    fun updateFeedback(feedback: Feedback) {
        updateState { state ->
            state.copy(sendFeedback = feedback)
        }
    }

    /**
     * Updates the filter for retrieving feedback.
     *
     * This function updates the current state with the new filter and then triggers
     * a call to [getFeedback] to fetch feedback based on the updated filter.
     *
     * @param filter The [GetFeedbackFilter] to apply.
     */
    fun updateFilter(filter: GetFeedbackFilter) {
        updateState { state ->
            state.copy(filter = filter)
        }
        getFeedback()
    }

    /**
     * Handles network errors by displaying a toast notification with retry and dismiss options.
     *
     * @param error The [NetworkError] that occurred.
     * @param onRetry A lambda function to be executed when the user clicks the "Retry" action.
     * @param updateState A lambda function to update the UI state with the error message.
     */
    private fun handleError(
        error: NetworkError,
        onRetry: () -> Unit,
        updateState: (String?) -> Unit,
    ) {
        println(error)
        updateState(error.message)

        Koffee.show(
            title = "Error",
            description = error.message ?: "Unknown error",
            type = ToastType.Error,
            duration = ToastDuration.Indefinite,
            primaryAction = ToastAction("Retry", onRetry, dismissAfter = true),
            secondaryAction = ToastAction(label = "Ok Got it", {}, true),
        )
    }
}

/**
 * Represents the different features available in an event.
 *
 * Each feature has a `label` which is a human-readable string representation of the feature.
 * This enum is serializable and uses `@SerialName` to define the string representation
 * for serialization and deserialization.
 *
 * @property label The human-readable label for the event feature.
 */
@Serializable
enum class EventFeature(val label: String) {
    @SerialName("Ticketing")
    TICKETING("Ticketing"),

    @SerialName("Events")
    EVENTS("Events"),

    @SerialName("Workshops")
    WORKSHOPS("Workshops"),

    @SerialName("Notifications")
    NOTIFICATIONS("Notifications"),

    @SerialName("Check-in")
    CHECK_IN("Check-in"),

    @SerialName("Schedule")
    SCHEDULE("Schedule"),

    @SerialName("Analytics")
    ANALYTICS("Analytics"),

    @SerialName("Sponsors")
    SPONSORS("Sponsors"),

    @SerialName("Venue Maps")
    MAPS("Venue Maps"),

    @SerialName("Networking")
    NETWORKING("Networking"),
}
