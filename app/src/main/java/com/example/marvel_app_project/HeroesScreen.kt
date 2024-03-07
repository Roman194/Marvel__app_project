package com.example.marvel_app_project

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController

enum class HeroesScreen {
    Start,
    SingleHero
}

@Composable
fun HeroesApp(navController: NavHostController = rememberNavController()){

    NavHost(
        navController = navController,
        startDestination = HeroesScreen.Start.name
    ) {
        composable(route = HeroesScreen.Start.name){
            ChooseHeroScreen(
                onHeroImageTaped = {
                    navController.navigate(HeroesScreen.SingleHero.name)
                }
            )
        }
        composable(route = HeroesScreen.SingleHero.name){
            SingleHeroScreen(navigateUp = {navController.navigateUp()})
        }
    }
}