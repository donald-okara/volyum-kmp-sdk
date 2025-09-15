//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.table](../index.md)/[UserMetadata](index.md)

# UserMetadata

[common]\
@Serializable

data class [UserMetadata](index.md)(val username: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val profileUrl: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null)

Represents metadata associated with a user, such as their username and profile URL. This class is serializable, allowing it to be easily converted to and from formats like JSON.

## Constructors

| | |
|---|---|
| [UserMetadata](-user-metadata.md) | [common]<br>constructor(username: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, profileUrl: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [profileUrl](profile-url.md) | [common]<br>@SerialName(value = &quot;profile_url&quot;)<br>val [profileUrl](profile-url.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The URL of the user's profile picture. This can be null if not available.     The `@SerialName("profile_url")` annotation indicates that when serialized,     this property will be represented by the key &quot;profile_url&quot;. |
| [username](username.md) | [common]<br>val [username](username.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The username of the user. This can be null if not available. |