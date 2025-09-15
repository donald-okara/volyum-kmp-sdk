//[volyum-lib](../../index.md)/[ke.don.volyum.feedback.model.domain](index.md)/[asEmptyDataResult](as-empty-data-result.md)

# asEmptyDataResult

[common]\
fun &lt;[T](as-empty-data-result.md), [E](as-empty-data-result.md) : [VolyumError](-volyum-error/index.md)&gt; [VolyumResult](-volyum-result/index.md)&lt;[T](as-empty-data-result.md), [E](as-empty-data-result.md)&gt;.[asEmptyDataResult](as-empty-data-result.md)(): [EmptyResult](-empty-result/index.md)&lt;[E](as-empty-data-result.md)&gt;

Converts a [VolyumResult](-volyum-result/index.md) to an [EmptyResult](-empty-result/index.md) by discarding the success data. If the original result was a [VolyumResult.Success](-volyum-result/-success/index.md), the new result will be a [VolyumResult.Success](-volyum-result/-success/index.md) with `Unit` data. If the original result was a [VolyumResult.Error](-volyum-result/-error/index.md), the new result will be a [VolyumResult.Error](-volyum-result/-error/index.md) with the same error.

#### Return

An [EmptyResult](-empty-result/index.md) which is a [VolyumResult](-volyum-result/index.md) with `Unit` as its success data type.

#### Parameters

common

| | |
|---|---|
| T | The type of the success data in the original result. |
| E | The type of the error in the original result. |