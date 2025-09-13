//[Volyum](../../../index.md)/[ke.don.volyum.feedback.model.domain](../index.md)/[NetworkError](index.md)

# NetworkError

[common]\
data class [NetworkError](index.md)(val category: [NetworkErrorCategory](../-network-error-category/index.md) = NetworkErrorCategory.UNKNOWN, val message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val code: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null) : [VolyumError](../-volyum-error/index.md)

Represents a network error that occurred during an operation.

This class encapsulates details about a network error, providing information about its category, a descriptive message, and an optional error code. It inherits from [VolyumError](../-volyum-error/index.md), making it part of a common error handling framework.

## Constructors

| | |
|---|---|
| [NetworkError](-network-error.md) | [common]<br>constructor(category: [NetworkErrorCategory](../-network-error-category/index.md) = NetworkErrorCategory.UNKNOWN, message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, code: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [category](category.md) | [common]<br>val [category](category.md): [NetworkErrorCategory](../-network-error-category/index.md)<br>The category of the network error, defaulting to [NetworkErrorCategory.UNKNOWN](../-network-error-category/-u-n-k-n-o-w-n/index.md).     This helps in classifying the type of network issue (e.g., connection timeout, server error). |
| [code](code.md) | [common]<br>val [code](code.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)? = null<br>An optional integer code associated with the network error (e.g., HTTP status code). This can be null. |
| [message](message.md) | [common]<br>val [message](message.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>A human-readable message describing the network error. This can be null if no specific message is available. |