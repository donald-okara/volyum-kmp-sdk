//[Volyum](../../../index.md)/[ke.don.volyum.feedback.config](../index.md)/[VolyumSdk](index.md)/[init](init.md)

# init

[common]\
fun [init](init.md)(config: [VolyumConfig](../-volyum-config/index.md))

Initializes the VolyumSdk with the provided configuration.

This function should be called only once during the application's lifecycle, typically in the Application class's `onCreate` method.

#### Parameters

common

| | |
|---|---|
| config | The [VolyumConfig](../-volyum-config/index.md) object containing the settings for the SDK. |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-state-exception/index.html) | if the SDK has already been initialized. |