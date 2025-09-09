package ke.don.birdie.demo.models

import ke.don.birdie.feedback.model.table.UserMetadata

data class UserData(
    val id: String = "",
    val name: String = "",
    val profileUrl: String = "",
){
    fun getRandom(): UserData {
        return UserData(
            id = (2..1000).random().toString(),
            name = FauxData.randomNames.random(),
            profileUrl = "https://picsum.photos/200?seed=$id"
        )
    }

    fun toMetadata(): UserMetadata {
        return UserMetadata(
            username = name,
            profileUrl = profileUrl
        )
    }
}
