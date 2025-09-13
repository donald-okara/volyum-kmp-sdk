//[composeApp](../../index.md)/[ke.don.volyum.demo](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AndroidPlatform](-android-platform/index.md) | [android]<br>class [AndroidPlatform](-android-platform/index.md) : Platform |
| [ComposeAppCommonTest](-compose-app-common-test/index.md) | [common]<br>class [ComposeAppCommonTest](-compose-app-common-test/index.md) |
| [Greeting](-greeting/index.md) | [common]<br>class [Greeting](-greeting/index.md) |
| [IOSPlatform](-i-o-s-platform/index.md) | [ios]<br>class [IOSPlatform](-i-o-s-platform/index.md) |
| [JVMPlatform](-j-v-m-platform/index.md) | [jvm]<br>class [JVMPlatform](-j-v-m-platform/index.md) : [Platform](-platform/index.md) |
| [MainActivity](-main-activity/index.md) | [android]<br>class [MainActivity](-main-activity/index.md) : [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html) |
| [Platform](-platform/index.md) | [common]<br>interface [Platform](-platform/index.md) |
| [VolyumCredentials](-volyum-credentials/index.md) | [common]<br>object [VolyumCredentials](-volyum-credentials/index.md)<br>Object holding Volyum configuration credentials. This object is typically used to store and provide access to the project ID and API key required for interacting with the Volyum service. |
| [VolyumDemoApplication](-volyum-demo-application/index.md) | [android]<br>class [VolyumDemoApplication](-volyum-demo-application/index.md) : [Application](https://developer.android.com/reference/kotlin/android/app/Application.html) |

## Functions

| Name | Summary |
|---|---|
| [App](-app.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>@Preview<br>fun [App](-app.md)()<br>Main application composable function. Sets up the theme, view model, state, and KoffeeBar for displaying toasts. It also launches an effect to fetch initial feedback data. The UI is rendered within a [Surface](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary.html) and KoffeeBar, with the main content provided by [FeedbackScreenContent](-feedback-screen-content.md). |
| [AppAndroidPreview](-app-android-preview.md) | [android]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [AppAndroidPreview](-app-android-preview.md)() |
| [FeedbackScreenContent](-feedback-screen-content.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [FeedbackScreenContent](-feedback-screen-content.md)(state: [FeedbackState](../ke.don.volyum.demo.models/-feedback-state/index.md), handleIntent: ([DemoIntentHandler](../ke.don.volyum.demo.models/-demo-intent-handler/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Composable function that displays the feedback screen content. It adapts the layout based on the window size class. |
| [getPlatform](get-platform.md) | [common, android, ios, jvm]<br>[common]<br>expect fun [getPlatform](get-platform.md)(): [Platform](-platform/index.md)<br>[android, ios]<br>actual fun [getPlatform](get-platform.md)(): Platform<br>[jvm]<br>actual fun [getPlatform](get-platform.md)(): [Platform](-platform/index.md) |
| [main](main.md) | [jvm]<br>fun [main](main.md)() |
| [MainViewController](-main-view-controller.md) | [ios]<br>fun [MainViewController](-main-view-controller.md)(): &lt;Error class: unknown class&gt; |
| [MobileScreen](-mobile-screen.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [MobileScreen](-mobile-screen.md)(state: [FeedbackState](../ke.don.volyum.demo.models/-feedback-state/index.md), handleIntent: ([DemoIntentHandler](../ke.don.volyum.demo.models/-demo-intent-handler/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Composable function for the mobile screen layout. It displays the feedback list and uses modal bottom sheets for details and form. |