//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.domain](../index.md)/[NetworkErrorCategory](index.md)

# NetworkErrorCategory

[common]\
enum [NetworkErrorCategory](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[NetworkErrorCategory](index.md)&gt; 

Represents different categories of network errors that can occur.

This enum is used to classify network-related issues, making it easier to handle and display appropriate messages or take specific actions based on the error type.

## Entries

| | |
|---|---|
| [REQUEST_TIMEOUT](-r-e-q-u-e-s-t_-t-i-m-e-o-u-t/index.md) | [common]<br>[REQUEST_TIMEOUT](-r-e-q-u-e-s-t_-t-i-m-e-o-u-t/index.md) |
| [UNAUTHORIZED](-u-n-a-u-t-h-o-r-i-z-e-d/index.md) | [common]<br>[UNAUTHORIZED](-u-n-a-u-t-h-o-r-i-z-e-d/index.md) |
| [CONFLICT](-c-o-n-f-l-i-c-t/index.md) | [common]<br>[CONFLICT](-c-o-n-f-l-i-c-t/index.md) |
| [TOO_MANY_REQUESTS](-t-o-o_-m-a-n-y_-r-e-q-u-e-s-t-s/index.md) | [common]<br>[TOO_MANY_REQUESTS](-t-o-o_-m-a-n-y_-r-e-q-u-e-s-t-s/index.md) |
| [NO_INTERNET](-n-o_-i-n-t-e-r-n-e-t/index.md) | [common]<br>[NO_INTERNET](-n-o_-i-n-t-e-r-n-e-t/index.md) |
| [PAYLOAD_TOO_LARGE](-p-a-y-l-o-a-d_-t-o-o_-l-a-r-g-e/index.md) | [common]<br>[PAYLOAD_TOO_LARGE](-p-a-y-l-o-a-d_-t-o-o_-l-a-r-g-e/index.md) |
| [SERVER_ERROR](-s-e-r-v-e-r_-e-r-r-o-r/index.md) | [common]<br>[SERVER_ERROR](-s-e-r-v-e-r_-e-r-r-o-r/index.md) |
| [SERIALIZATION](-s-e-r-i-a-l-i-z-a-t-i-o-n/index.md) | [common]<br>[SERIALIZATION](-s-e-r-i-a-l-i-z-a-t-i-o-n/index.md) |
| [UNKNOWN](-u-n-k-n-o-w-n/index.md) | [common]<br>[UNKNOWN](-u-n-k-n-o-w-n/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [common]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[NetworkErrorCategory](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](../../ke.don.volyum.feedback.model.table/-feedback-status/-rejected/index.md#-372974862%2FProperties%2F-1200628132) | [common]<br>val [name](../../ke.don.volyum.feedback.model.table/-feedback-status/-rejected/index.md#-372974862%2FProperties%2F-1200628132): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [ordinal](../../ke.don.volyum.feedback.model.table/-feedback-status/-rejected/index.md#-739389684%2FProperties%2F-1200628132) | [common]<br>val [ordinal](../../ke.don.volyum.feedback.model.table/-feedback-status/-rejected/index.md#-739389684%2FProperties%2F-1200628132): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [NetworkErrorCategory](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[NetworkErrorCategory](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |