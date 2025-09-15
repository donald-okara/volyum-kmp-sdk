//[volyum-lib](../../index.md)/[ke.don.volyum.feedback.model.domain](index.md)/[map](map.md)

# map

[common]\
inline fun &lt;[T](map.md), [E](map.md) : [VolyumError](-volyum-error/index.md), [R](map.md)&gt; [VolyumResult](-volyum-result/index.md)&lt;[T](map.md), [E](map.md)&gt;.[map](map.md)(map: ([T](map.md)) -&gt; [R](map.md)): [VolyumResult](-volyum-result/index.md)&lt;[R](map.md), [E](map.md)&gt;

Transforms the successful result's data using the provided `map` function. If the result is an error, it returns the original error.

#### Return

A new [VolyumResult](-volyum-result/index.md) with the transformed data if successful, or the original error if not.

#### Parameters

common

| | |
|---|---|
| map | A function to apply to the successful result's data. |
| T | The type of the original successful data. |
| E | The type of the error, which must extend [VolyumError](-volyum-error/index.md). |
| R | The type of the transformed successful data. |