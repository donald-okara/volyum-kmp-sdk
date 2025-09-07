package ke.don.birdie.feedback.config

import ke.don.birdie.feedback.helpers.EntityUUID
import ke.don.birdie.feedback.model.domain.BirdieResult
import ke.don.birdie.feedback.model.domain.NetworkError
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.network.api.ApiClient

class Birdie internal constructor(
    private val apiClient: ApiClient,
) {
    suspend fun sendFeedback(feedback: Feedback): BirdieResult<EntityUUID, NetworkError> = apiClient.addFeedback( feedback = feedback )

}
