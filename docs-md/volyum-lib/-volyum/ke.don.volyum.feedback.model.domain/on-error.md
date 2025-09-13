//[Volyum](../../index.md)/[ke.don.volyum.feedback.model.domain](index.md)/[onError](on-error.md)

# onError

[common]\
inline fun &lt;[T](on-error.md), [E](on-error.md) : [VolyumError](-volyum-error/index.md)&gt; [VolyumResult](-volyum-result/index.md)&lt;[T](on-error.md), [E](on-error.md)&gt;.[onError](on-error.md)(action: ([E](on-error.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [VolyumResult](-volyum-result/index.md)&lt;[T](on-error.md), [E](on-error.md)&gt;

Executes the given [action](on-error.md) if this [VolyumResult](-volyum-result/index.md) is an [VolyumResult.Error](-volyum-result/-error/index.md). The original [VolyumResult](-volyum-result/index.md) is returned, regardless of whether it's an error or success.

#### Return

The original [VolyumResult](-volyum-result/index.md) instance.

#### Parameters

common

| | |
|---|---|
| action | The action to be executed with the error of type [E](on-error.md) if this is an [VolyumResult.Error](-volyum-result/-error/index.md). |