/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.demo.models

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSizeClass { Compact, Medium, Expanded }

fun getWindowSizeClass(windowDpWidth: Dp): WindowSizeClass {
    return when {
        windowDpWidth < 600.dp -> WindowSizeClass.Compact // Phones
        windowDpWidth < 840.dp -> WindowSizeClass.Medium // Tablets, Foldables
        else -> WindowSizeClass.Expanded // Desktops
    }
}
