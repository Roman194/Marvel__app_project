package com.example.marvel_app_project.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Apply transparent system bar colors (status bar and navigation bar).
 * This function uses the Accompanist library to control the system UI colors.
 * It sets both the status bar and navigation bar colors to transparent.
 */
@Composable
fun ApplySystemBarColors(){
    val systemUiContrller = rememberSystemUiController()

    SideEffect {
        systemUiContrller.setStatusBarColor(color = Color.Transparent)
        systemUiContrller.setNavigationBarColor(color = Color.Transparent)
    }
}