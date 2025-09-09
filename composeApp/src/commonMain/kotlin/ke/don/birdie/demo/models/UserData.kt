package ke.don.birdie.demo.models

data class UserData(
    val id: String = "",
    val name: String = "",
    val profileUrl: String = "",
){
    fun getRandom(): UserData {
        return UserData(
            id = (1..1000).random().toString(),
            name = FauxData.randomNames.random(),
            profileUrl = "https://picsum.photos/200?seed=$id"
        )
    }
}
