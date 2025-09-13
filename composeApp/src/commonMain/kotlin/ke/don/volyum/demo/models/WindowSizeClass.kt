/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.models

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Represents the different window size classes based on screen width.
 * This enum helps in creating responsive UIs by categorizing screen sizes.
 *
 * - [Compact]: Typically represents phone-sized screens.
 * - [Medium]: Typically represents tablet or foldable-sized screens.
 * - [Expanded]: Typically represents desktop or larger screen sizes.
 */
enum class WindowSizeClass { Compact, Medium, Expanded }

/**
 * Determines the [WindowSizeClass] based on the provided window width in Dp.
 *
 * This function categorizes the window size into one of three classes:
 * - [WindowSizeClass.Compact]: Typically for phones (width < 600.dp).
 * - [WindowSizeClass.Medium]: Typically for tablets and foldables (600.dp <= width < 840.dp).
 * - [WindowSizeClass.Expanded]: Typically for desktops (width >= 840.dp).
 *
 * @param windowDpWidth The width of the window in Dp.
 * @return The corresponding [WindowSizeClass].
 */
fun getWindowSizeClass(windowDpWidth: Dp): WindowSizeClass {
    return when {
        windowDpWidth < 600.dp -> WindowSizeClass.Compact // Phones
        windowDpWidth < 840.dp -> WindowSizeClass.Medium // Tablets, Foldables
        else -> WindowSizeClass.Expanded // Desktops
    }
}
