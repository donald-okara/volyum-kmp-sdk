//[composeApp](../../index.md)/[ke.don.volyum.demo.components](index.md)/[ProfileHeader](-profile-header.md)

# ProfileHeader

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ProfileHeader](-profile-header.md)(userData: [UserData](../ke.don.volyum.demo.models/-user-data/index.md), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, status: FeedbackStatus = FeedbackStatus.Pending)

Displays the user's profile information, including their avatar, name, and feedback status.

#### Parameters

common

| | |
|---|---|
| userData | The user's data, including their name and profile URL. |
| modifier | Optional [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) for this composable. |
| status | The status of the feedback (e.g., Pending, Approved, Rejected). |