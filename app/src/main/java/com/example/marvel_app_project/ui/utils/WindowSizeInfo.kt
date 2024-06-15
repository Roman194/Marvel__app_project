package com.example.marvel_app_project.ui.utils

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