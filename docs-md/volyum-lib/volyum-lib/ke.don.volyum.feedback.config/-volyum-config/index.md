//[volyum-lib](../../../index.md)/[ke.don.volyum.feedback.config](../index.md)/[VolyumConfig](index.md)

# VolyumConfig

[common]\
data class [VolyumConfig](index.md)(val projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val apiKey: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))

Configuration class for Volyum.

This data class holds the necessary credentials to interact with the Volyum API.

## Constructors

| | |
|---|---|
| [VolyumConfig](-volyum-config.md) | [common]<br>constructor(projectId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), apiKey: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [apiKey](api-key.md) | [common]<br>val [apiKey](api-key.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The API key associated with your Volyum project for authentication. |
| [projectId](project-id.md) | [common]<br>val [projectId](project-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The unique identifier for your Volyum project. |

## Functions

| Name | Summary |
|---|---|
| [toProjectIdentifier](to-project-identifier.md) | [common]<br>fun [toProjectIdentifier](to-project-identifier.md)(): [ProjectIdentity](../../ke.don.volyum.feedback.model.domain/-project-identity/index.md) |