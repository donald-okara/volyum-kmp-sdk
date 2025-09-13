//[Volyum](../../../../index.md)/[ke.don.volyum.feedback.model.domain](../../index.md)/[VolyumResult](../index.md)/[Error](index.md)

# Error

[common]\
data class [Error](index.md)&lt;out [E](index.md) : [VolyumError](../../-volyum-error/index.md)&gt;(val error: [E](index.md)) : [VolyumResult](../index.md)&lt;[Nothing](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-nothing/index.html), [E](index.md)&gt;

## Constructors

| | |
|---|---|
| [Error](-error.md) | [common]<br>constructor(error: [E](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [error](error.md) | [common]<br>val [error](error.md): [E](index.md) |

## Functions

| Name | Summary |
|---|---|
| [asEmptyDataResult](../../as-empty-data-result.md) | [common]<br>fun &lt;[T](../../as-empty-data-result.md), [E](../../as-empty-data-result.md) : [VolyumError](../../-volyum-error/index.md)&gt; [VolyumResult](../index.md)&lt;[T](../../as-empty-data-result.md), [E](../../as-empty-data-result.md)&gt;.[asEmptyDataResult](../../as-empty-data-result.md)(): [EmptyResult](../../-empty-result/index.md)&lt;[E](../../as-empty-data-result.md)&gt;<br>Converts a [VolyumResult](../index.md) to an [EmptyResult](../../-empty-result/index.md) by discarding the success data. If the original result was a [VolyumResult.Success](../-success/index.md), the new result will be a [VolyumResult.Success](../-success/index.md) with `Unit` data. If the original result was a [VolyumResult.Error](index.md), the new result will be a [VolyumResult.Error](index.md) with the same error. |
| [isSuccess](../../is-success.md) | [common]<br>fun [VolyumResult](../index.md)&lt;*, *&gt;.[isSuccess](../../is-success.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the [VolyumResult](../index.md) is a [VolyumResult.Success](../-success/index.md). |
| [map](../../map.md) | [common]<br>inline fun &lt;[T](../../map.md), [E](../../map.md) : [VolyumError](../../-volyum-error/index.md), [R](../../map.md)&gt; [VolyumResult](../index.md)&lt;[T](../../map.md), [E](../../map.md)&gt;.[map](../../map.md)(map: ([T](../../map.md)) -&gt; [R](../../map.md)): [VolyumResult](../index.md)&lt;[R](../../map.md), [E](../../map.md)&gt;<br>Transforms the successful result's data using the provided `map` function. If the result is an error, it returns the original error. |
| [onError](../../on-error.md) | [common]<br>inline fun &lt;[T](../../on-error.md), [E](../../on-error.md) : [VolyumError](../../-volyum-error/index.md)&gt; [VolyumResult](../index.md)&lt;[T](../../on-error.md), [E](../../on-error.md)&gt;.[onError](../../on-error.md)(action: ([E](../../on-error.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [VolyumResult](../index.md)&lt;[T](../../on-error.md), [E](../../on-error.md)&gt;<br>Executes the given [action](../../on-error.md) if this [VolyumResult](../index.md) is an [VolyumResult.Error](index.md). The original [VolyumResult](../index.md) is returned, regardless of whether it's an error or success. |
| [onSuccess](../../on-success.md) | [common]<br>inline fun &lt;[T](../../on-success.md), [E](../../on-success.md) : [VolyumError](../../-volyum-error/index.md)&gt; [VolyumResult](../index.md)&lt;[T](../../on-success.md), [E](../../on-success.md)&gt;.[onSuccess](../../on-success.md)(action: ([T](../../on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [VolyumResult](../index.md)&lt;[T](../../on-success.md), [E](../../on-success.md)&gt;<br>Executes the given [action](../../on-success.md) if this [VolyumResult](../index.md) is a [VolyumResult.Success](../-success/index.md). Returns the original [VolyumResult](../index.md) unchanged. |