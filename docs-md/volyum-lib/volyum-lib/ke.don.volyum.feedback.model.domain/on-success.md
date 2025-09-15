//[volyum-lib](../../index.md)/[ke.don.volyum.feedback.model.domain](index.md)/[onSuccess](on-success.md)

# onSuccess

[common]\
inline fun &lt;[T](on-success.md), [E](on-success.md) : [VolyumError](-volyum-error/index.md)&gt; [VolyumResult](-volyum-result/index.md)&lt;[T](on-success.md), [E](on-success.md)&gt;.[onSuccess](on-success.md)(action: ([T](on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [VolyumResult](-volyum-result/index.md)&lt;[T](on-success.md), [E](on-success.md)&gt;

Executes the given [action](on-success.md) if this [VolyumResult](-volyum-result/index.md) is a [VolyumResult.Success](-volyum-result/-success/index.md). Returns the original [VolyumResult](-volyum-result/index.md) unchanged.

#### Return

The original [VolyumResult](-volyum-result/index.md).

#### Parameters

common

| | |
|---|---|
| T | The type of the successful data. |
| E | The type of the error. |
| action | The action to execute with the successful data. |