package ke.don.birdie.demo.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
actual fun systemInDarkTheme(): Boolean = isSystemInDarkTheme()