package com.example.marvel_app_project.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ApplySystemBarColors(){
    val systemUiContrller = rememberSystemUiController()

    SideEffect {
        systemUiContrller.setStatusBarColor(color = Color.Transparent)
        systemUiContrller.setNavigationBarColor(color = Color.Transparent)
    }
}