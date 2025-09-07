package ke.don.birdie.feedback.config

import ke.don.birdie.feedback.network.api.ApiClientImpl

object BirdieFactory {
    fun create(config: BirdieConfig): Birdie {
        val apiClient = ApiClientImpl(config.toProjectIdentifier())
        return Birdie(apiClient)
    }
}