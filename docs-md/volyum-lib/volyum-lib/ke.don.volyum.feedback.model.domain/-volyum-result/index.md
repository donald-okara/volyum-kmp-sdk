//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.model.domain](../index.md)/[VolyumResult](index.md)

# VolyumResult

sealed interface [VolyumResult](index.md)&lt;out [D](index.md), out [E](index.md) : [VolyumError](../-volyum-error/index.md)&gt;

A sealed interface representing the result of an operation that can either be successful or result in an error.

This is commonly used in scenarios where an operation might fail, and you need to handle both success and error cases.

#### Parameters

common

| | |
|---|---|
| D | The type of data expected in a successful result. |
| E | The type of error expected in an error result, constrained to be a subtype of [VolyumError](../-volyum-error/index.md). |

#### Inheritors

| |
|---|
| [Success](-success/index.md) |
| [Error](-error/index.md) |

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [common]<br>data class [Error](-error/index.md)&lt;out [E](-error/index.md) : [VolyumError](../-volyum-error/index.md)&gt;(val error: [E](-error/index.md)) : [VolyumResult](index.md)&lt;[Nothing](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-nothing/index.html), [E](-error/index.md)&gt; |
| [Success](-success/index.md) | [common]<br>data class [Success](-success/index.md)&lt;out [D](-success/index.md)&gt;(val data: [D](-success/index.md)) : [VolyumResult](index.md)&lt;[D](-success/index.md), [Nothing](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-nothing/index.html)&gt; |

## Functions

| Name | Summary |
|---|---|
| [asEmptyDataResult](../as-empty-data-result.md) | [common]<br>fun &lt;[T](../as-empty-data-result.md), [E](../as-empty-data-result.md) : [VolyumError](../-volyum-error/index.md)&gt; [VolyumResult](index.md)&lt;[T](../as-empty-data-result.md), [E](../as-empty-data-result.md)&gt;.[asEmptyDataResult](../as-empty-data-result.md)(): [EmptyResult](../-empty-result/index.md)&lt;[E](../as-empty-data-result.md)&gt;<br>Converts a [VolyumResult](index.md) to an [EmptyResult](../-empty-result/index.md) by discarding the success data. If the original result was a [VolyumResult.Success](-success/index.md), the new result will be a [VolyumResult.Success](-success/index.md) with `Unit` data. If the original result was a [VolyumResult.Error](-error/index.md), the new result will be a [VolyumResult.Error](-error/index.md) with the same error. |
| [isSuccess](../is-success.md) | [common]<br>fun [VolyumResult](index.md)&lt;*, *&gt;.[isSuccess](../is-success.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the [VolyumResult](index.md) is a [VolyumResult.Success](-success/index.md). |
| [map](../map.md) | [common]<br>inline fun &lt;[T](../map.md), [E](../map.md) : [VolyumError](../-volyum-error/index.md), [R](../map.md)&gt; [VolyumResult](index.md)&lt;[T](../map.md), [E](../map.md)&gt;.[map](../map.md)(map: ([T](../map.md)) -&gt; [R](../map.md)): [VolyumResult](index.md)&lt;[R](../map.md), [E](../map.md)&gt;<br>Transforms the successful result's data using the provided `map` function. If the result is an error, it returns the original error. |
| [onError](../on-error.md) | [common]<br>inline fun &lt;[T](../on-error.md), [E](../on-error.md) : [VolyumError](../-volyum-error/index.md)&gt; [VolyumResult](index.md)&lt;[T](../on-error.md), [E](../on-error.md)&gt;.[onError](../on-error.md)(action: ([E](../on-error.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [VolyumResult](index.md)&lt;[T](../on-error.md), [E](../on-error.md)&gt;<br>Executes the given [action](../on-error.md) if this [VolyumResult](index.md) is an [VolyumResult.Error](-error/index.md). The original [VolyumResult](index.md) is returned, regardless of whether it's an error or success. |
| [onSuccess](../on-success.md) | [common]<br>inline fun &lt;[T](../on-success.md), [E](../on-success.md) : [VolyumError](../-volyum-error/index.md)&gt; [VolyumResult](index.md)&lt;[T](../on-success.md), [E](../on-success.md)&gt;.[onSuccess](../on-success.md)(action: ([T](../on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [VolyumResult](index.md)&lt;[T](../on-success.md), [E](../on-success.md)&gt;<br>Executes the given [action](../on-success.md) if this [VolyumResult](index.md) is a [VolyumResult.Success](-success/index.md). Returns the original [VolyumResult](index.md) unchanged. |