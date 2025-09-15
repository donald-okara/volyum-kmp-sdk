//[composeApp](../../index.md)/[ke.don.volyum.demo.models](index.md)/[getWindowSizeClass](get-window-size-class.md)

# getWindowSizeClass

[common]\
fun [getWindowSizeClass](get-window-size-class.md)(windowDpWidth: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html)): [WindowSizeClass](-window-size-class/index.md)

Determines the [WindowSizeClass](-window-size-class/index.md) based on the provided window width in Dp.

This function categorizes the window size into one of three classes:

- 
   [WindowSizeClass.Compact](-window-size-class/-compact/index.md): Typically for phones (width < 600.dp).
- 
   [WindowSizeClass.Medium](-window-size-class/-medium/index.md): Typically for tablets and foldables (600.dp <= width < 840.dp).
- 
   [WindowSizeClass.Expanded](-window-size-class/-expanded/index.md): Typically for desktops (width >= 840.dp).

#### Return

The corresponding [WindowSizeClass](-window-size-class/index.md).

#### Parameters

common

| | |
|---|---|
| windowDpWidth | The width of the window in Dp. |