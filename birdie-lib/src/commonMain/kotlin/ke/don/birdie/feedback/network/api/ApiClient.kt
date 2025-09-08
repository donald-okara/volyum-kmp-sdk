package ke.don.birdie.feedback.network.api

import ke.don.birdie.feedback.helpers.EntityUUID
import ke.don.birdie.feedback.model.domain.BirdieResult
import ke.don.birdie.feedback.model.domain.NetworkError
import ke.don.birdie.feedback.model.domain.ProjectIdentity
import ke.don.birdie.feedback.model.table.Feedback

internal interface ApiClient {
    suspend fun addFeedback(
        feedback: Feedback,
    ): BirdieResult<Feedback, NetworkError>



}