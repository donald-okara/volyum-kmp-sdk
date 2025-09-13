//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[UserData](index.md)

# UserData

[common]\
data class [UserData](index.md)(val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, val profileUrl: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;)

Represents user data.

## Constructors

| | |
|---|---|
| [UserData](-user-data.md) | [common]<br>constructor(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, profileUrl: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [id](id.md) | [common]<br>val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The unique identifier for the user. Defaults to an empty string. |
| [name](name.md) | [common]<br>val [name](name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The name of the user. Defaults to an empty string. |
| [profileUrl](profile-url.md) | [common]<br>val [profileUrl](profile-url.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The URL of the user's profile picture. Defaults to an empty string. |

## Functions

| Name | Summary |
|---|---|
| [getRandom](get-random.md) | [common]<br>fun [getRandom](get-random.md)(): [UserData](index.md)<br>Generates a random [UserData](index.md) object. The ID is a random number between 2 and 1000, converted to a string. The name is a randomly selected name from [FauxData.randomNames](../-faux-data/random-names.md). The profile URL is generated using picsum.photos with the generated ID as the seed. |
| [toMetadata](to-metadata.md) | [common]<br>fun [toMetadata](to-metadata.md)(): UserMetadata<br>Converts this UserData object to a UserMetadata object. |