/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo

import androidx.compose.runtime.SideEffect
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.donald_okara.volyum.config.VolyumSdk

fun main() = application {
    VolyumSdk.init(VolyumCredentials.CONFIG)

    Window(
        onCloseRequest = ::exitApplication,
        title = "VolyumSDK",
    ) {
        SideEffect { window.minimumSize = java.awt.Dimension(600, 400) } // px, not dp

        App()
    }
}
