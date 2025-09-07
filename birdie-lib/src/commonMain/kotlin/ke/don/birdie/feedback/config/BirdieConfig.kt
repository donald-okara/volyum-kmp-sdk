package ke.don.birdie.feedback.config

import ke.don.birdie.feedback.model.domain.ProjectIdentity

data class BirdieConfig(
    val projectId: String,
    val apiKey: String,
){
    fun toProjectIdentifier(): ProjectIdentity{
        return ProjectIdentity(
            id = projectId,
            key = apiKey
        )
    }
}