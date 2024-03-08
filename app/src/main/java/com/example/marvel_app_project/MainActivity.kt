package com.example.marvel_app_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.example.marvel_app_project.ui.theme.Marvel_app_projectTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            Marvel_app_projectTheme {
                // A surface container using the 'background' color from the theme
                ApplySystemBarColors()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroesApp()
                    //ChooseHeroScreen()
                }
            }
        }
    }
}

@Composable
private fun ApplySystemBarColors(){
    val systemUiContrller = rememberSystemUiController()

    SideEffect {
        systemUiContrller.setStatusBarColor(color = Color.Transparent)
        systemUiContrller.setNavigationBarColor(color = Color.Transparent)
    }
}
