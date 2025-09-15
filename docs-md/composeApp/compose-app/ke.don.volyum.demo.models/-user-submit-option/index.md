//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[UserSubmitOption](index.md)

# UserSubmitOption

[common]\
enum [UserSubmitOption](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[UserSubmitOption](index.md)&gt; 

Represents the options available to a user when submitting feedback.

Each option has a human-readable [description](description.md).

- 
   [MyProfile](-my-profile/index.md): Allows the user to submit feedback associated with their own profile.
- 
   [Anonymous](-anonymous/index.md): Allows the user to submit feedback without revealing their identity.
- 
   [RandomUser](-random-user/index.md): Allows submitting feedback as a randomly generated user. **This option should only be used for testing or development purposes and never in a production environment.**

## Entries

| | |
|---|---|
| [MyProfile](-my-profile/index.md) | [common]<br>[MyProfile](-my-profile/index.md) |
| [Anonymous](-anonymous/index.md) | [common]<br>[Anonymous](-anonymous/index.md) |
| [RandomUser](-random-user/index.md) | [common]<br>[RandomUser](-random-user/index.md) |

## Properties

| Name | Summary |
|---|---|
| [description](description.md) | [common]<br>val [description](description.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [entries](entries.md) | [common]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[UserSubmitOption](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](../-window-size-class/-expanded/index.md#-372974862%2FProperties%2F-1518758877) | [common]<br>val [name](../-window-size-class/-expanded/index.md#-372974862%2FProperties%2F-1518758877): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [ordinal](../-window-size-class/-expanded/index.md#-739389684%2FProperties%2F-1518758877) | [common]<br>val [ordinal](../-window-size-class/-expanded/index.md#-739389684%2FProperties%2F-1518758877): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [UserSubmitOption](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[UserSubmitOption](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |