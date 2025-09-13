//[Volyum](../../../index.md)/[ke.don.volyum.feedback.config](../index.md)/[VolyumSdk](index.md)

# VolyumSdk

[common]\
object [VolyumSdk](index.md)

The entry point for the Volyum SDK.

This object provides methods to initialize and access the Volyum instance. It ensures that the SDK is initialized only once and provides a convenient way to get the initialized Volyum instance.

Example usage:

```kotlin
// Initialize the SDK with a configuration
VolyumSdk.init(VolyumConfig(...))

// Get the Volyum instance
val volyum = VolyumSdk.get()

// Use the Volyum instance
volyum.someMethod()
```

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [common]<br>fun [get](get.md)(): [Volyum](../-volyum/index.md)<br>Retrieves the initialized Volyum instance. |
| [init](init.md) | [common]<br>fun [init](init.md)(config: [VolyumConfig](../-volyum-config/index.md))<br>Initializes the VolyumSdk with the provided configuration. |