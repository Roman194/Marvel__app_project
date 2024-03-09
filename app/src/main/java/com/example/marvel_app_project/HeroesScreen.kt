package com.example.marvel_app_project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_project.data.Heroes
import com.example.marvel_app_project.ui.ChooseHeroScreen
import com.example.marvel_app_project.ui.SingleHeroScreen

enum class HeroesScreen {
    Start,
    SingleHero
}

@Composable
fun HeroesApp(navController: NavHostController = rememberNavController()){

    val heroesState = remember {
        mutableStateOf(
            Heroes("Info","Info description","", R.color.white)
        )
    }

    NavHost(
        navController = navController,
        startDestination = HeroesScreen.Start.name
    ) {
        composable(route = HeroesScreen.Start.name){
            ChooseHeroScreen(
                onHeroImageTaped = {hero ->
                    heroesState.value = hero
                    navController.navigate(HeroesScreen.SingleHero.name)
                }
            )
        }
        composable(route = HeroesScreen.SingleHero.name){
            SingleHeroScreen(
                hero = heroesState.value,
                navigateUp = {navController.navigateUp()}
            )
        }
    }
}