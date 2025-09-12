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
import ke.don.volyum.demo.FeedbackState
import ke.don.volyum.feedback.config.VolyumSdk
import ke.don.volyum.feedback.model.domain.NetworkError
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.volyum.feedback.model.domain.onError
import ke.don.volyum.feedback.model.domain.onSuccess
import ke.don.volyum.feedback.model.table.Feedback
import ke.don.volyum.feedback.model.table.UserMetadata
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

class FeedbackViewModel : ViewModel() {
    val volyum = VolyumSdk.get()
    private val _uiState = MutableStateFlow(FeedbackState())
    val uiState: StateFlow<FeedbackState> = _uiState

    fun updateState(transform: (FeedbackState) -> FeedbackState) {
        _uiState.update { state ->
            transform(state)
        }
    }

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

    fun updateFeedback(feedback: Feedback) {
        updateState { state ->
            state.copy(sendFeedback = feedback)
        }
    }

    fun updateFilter(filter: GetFeedbackFilter) {
        updateState { state ->
            state.copy(filter = filter)
        }
        getFeedback()
    }

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
