package com.example.marvel_app_project.ui.utils

/**
 * Data class representing window size information.
 * It contains information about the screen width and height types.
 * This can be useful for responsive UI design.
 * @property screenWidthInfo The type of screen width (Compact, Medium, Expanded).
 * @property screenHeightInfo The type of screen height (Compact, Medium, Expanded).
 * @author Zyuzin Roman
 */

data class WindowSizeInfo(
    val screenWidthInfo: WindowSizeType,
    val screenHeightInfo: WindowSizeType,
) {
    sealed class WindowSizeType {
        object Compact : WindowSizeType()
        object Medium : WindowSizeType()
        object Expanded : WindowSizeType()
    }
}