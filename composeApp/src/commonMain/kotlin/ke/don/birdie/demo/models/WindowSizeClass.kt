package ke.don.birdie.demo.models

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSizeClass { Compact, Medium, Expanded }

fun getWindowSizeClass(windowDpWidth: Dp): WindowSizeClass {
    return when {
        windowDpWidth < 600.dp -> WindowSizeClass.Compact   // Phones
        windowDpWidth < 840.dp -> WindowSizeClass.Medium    // Tablets, Foldables
        else -> WindowSizeClass.Expanded                    // Desktops
    }
}
