package ke.don.birdie.demo.models

import androidx.lifecycle.ViewModel
import ke.don.birdie.demo.FeedbackState
import ke.don.birdie.feedback.config.BirdieSdk
import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.birdie.feedback.model.table.Feedback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

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

    suspend fun getFeedback() {
        birdie.getFeedback(uiState.value.filter)
    }

    suspend fun getFeedbackById(id: String) {
        birdie.getFeedbackById(id)
    }

    suspend fun sendFeedback() {
        birdie.sendFeedback(uiState.value.sendFeedback)
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