package ke.don.birdie.demo.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.don.birdie.demo.FeedbackState
import ke.don.birdie.feedback.config.BirdieSdk
import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.birdie.feedback.model.domain.onError
import ke.don.birdie.feedback.model.domain.onSuccess
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.model.table.UserMetadata
import ke.don.koffee.domain.Koffee
import ke.don.koffee.model.ToastAction
import ke.don.koffee.model.ToastDuration
import ke.don.koffee.model.ToastType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedbackViewModel: ViewModel() {
    val birdie = BirdieSdk.get()

    private val myUserData = UserData(
        id = "1",
        name = "Donald",
        profileUrl = "https://picsum.photos/200?seed=1"
    )

    private val _uiState = MutableStateFlow(FeedbackState())
    val uiState: StateFlow<FeedbackState> = _uiState

    fun updateState(transform: (FeedbackState) -> FeedbackState) {
        _uiState.update { state ->
            transform(state)
        }
    }

    fun handleIndent(intent: DemoIntentHandler){
        when(intent){
            is DemoIntentHandler.GetFeedback -> getFeedback()
            is DemoIntentHandler.GetFeedbackById -> getFeedbackById(intent.id)
            is DemoIntentHandler.SendFeedback -> sendFeedback(intent.option)
        }
    }

    fun getFeedback() {
        viewModelScope.launch {
            updateState {
                it.copy(listIsLoading = true)
            }
            birdie.getFeedback(uiState.value.filter)
                .onSuccess {
                    updateState { state ->
                        state.copy(
                            feedbackList = it,
                            listIsLoading = false
                        )
                    }
                }
                .onError {
                    println(it)
                    updateState { state ->
                        state.copy(
                            listIsLoading = false,
                            listIsError = true,
                            listErrorMessage = it.message
                        )
                    }

                    Koffee.show(
                        title = "Error",
                        description = it.message ?: "Unknown error",
                        type = ToastType.Error,
                        duration = ToastDuration.Indefinite,
                        primaryAction = ToastAction("Retry", { getFeedback() }, dismissAfter = true),
                        secondaryAction = ToastAction(label = "Ok Got it", {} , true)
                    )
                }
        }
    }

    fun getFeedbackById(id: String) {
        viewModelScope.launch {
            birdie.getFeedbackById(id)
        }
    }

    fun sendFeedback(option: UserSubmitOption) {
        val userData = when(option){
            UserSubmitOption.MyProfile -> myUserData
            UserSubmitOption.Anonymous -> null
            UserSubmitOption.RandomUser -> UserData().getRandom()
        }
        viewModelScope.launch {
            birdie.sendFeedback(
                uiState.value.sendFeedback.copy(
                    userId = userData?.id,
                    userMetadata = UserMetadata(
                        username = userData?.name,
                        profileUrl = userData?.profileUrl
                    )
                )
            )
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
    }

}