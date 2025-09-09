package ke.don.birdie.demo.models

enum class UserSubmitOption(val description: String) {
    MyProfile(
        "Submit feedback with my profile"
    ),
    Anonymous(
        "Submit feedback anonymously"
    ),
    RandomUser(
        "Submit feedback to with a random user"
    )
}