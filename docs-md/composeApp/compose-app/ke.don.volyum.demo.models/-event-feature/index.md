//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[EventFeature](index.md)

# EventFeature

[common]\
@Serializable

enum [EventFeature](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[EventFeature](index.md)&gt; 

Represents the different features available in an event.

Each feature has a `label` which is a human-readable string representation of the feature. This enum is serializable and uses `@SerialName` to define the string representation for serialization and deserialization.

## Entries

| | |
|---|---|
| [TICKETING](-t-i-c-k-e-t-i-n-g/index.md) | [common]<br>@SerialName(value = &quot;Ticketing&quot;)<br>[TICKETING](-t-i-c-k-e-t-i-n-g/index.md) |
| [EVENTS](-e-v-e-n-t-s/index.md) | [common]<br>@SerialName(value = &quot;Events&quot;)<br>[EVENTS](-e-v-e-n-t-s/index.md) |
| [WORKSHOPS](-w-o-r-k-s-h-o-p-s/index.md) | [common]<br>@SerialName(value = &quot;Workshops&quot;)<br>[WORKSHOPS](-w-o-r-k-s-h-o-p-s/index.md) |
| [NOTIFICATIONS](-n-o-t-i-f-i-c-a-t-i-o-n-s/index.md) | [common]<br>@SerialName(value = &quot;Notifications&quot;)<br>[NOTIFICATIONS](-n-o-t-i-f-i-c-a-t-i-o-n-s/index.md) |
| [CHECK_IN](-c-h-e-c-k_-i-n/index.md) | [common]<br>@SerialName(value = &quot;Check-in&quot;)<br>[CHECK_IN](-c-h-e-c-k_-i-n/index.md) |
| [SCHEDULE](-s-c-h-e-d-u-l-e/index.md) | [common]<br>@SerialName(value = &quot;Schedule&quot;)<br>[SCHEDULE](-s-c-h-e-d-u-l-e/index.md) |
| [ANALYTICS](-a-n-a-l-y-t-i-c-s/index.md) | [common]<br>@SerialName(value = &quot;Analytics&quot;)<br>[ANALYTICS](-a-n-a-l-y-t-i-c-s/index.md) |
| [SPONSORS](-s-p-o-n-s-o-r-s/index.md) | [common]<br>@SerialName(value = &quot;Sponsors&quot;)<br>[SPONSORS](-s-p-o-n-s-o-r-s/index.md) |
| [MAPS](-m-a-p-s/index.md) | [common]<br>@SerialName(value = &quot;Venue Maps&quot;)<br>[MAPS](-m-a-p-s/index.md) |
| [NETWORKING](-n-e-t-w-o-r-k-i-n-g/index.md) | [common]<br>@SerialName(value = &quot;Networking&quot;)<br>[NETWORKING](-n-e-t-w-o-r-k-i-n-g/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [common]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[EventFeature](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [label](label.md) | [common]<br>val [label](label.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The human-readable label for the event feature. |
| [name](../-window-size-class/-expanded/index.md#-372974862%2FProperties%2F-1518758877) | [common]<br>val [name](../-window-size-class/-expanded/index.md#-372974862%2FProperties%2F-1518758877): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [ordinal](../-window-size-class/-expanded/index.md#-739389684%2FProperties%2F-1518758877) | [common]<br>val [ordinal](../-window-size-class/-expanded/index.md#-739389684%2FProperties%2F-1518758877): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [EventFeature](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[EventFeature](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |