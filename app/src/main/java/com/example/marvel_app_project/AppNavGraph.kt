package com.example.marvel_app_project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_project.models.Heroes
import com.example.marvel_app_project.ui.pages.ChooseHeroScreen
import com.example.marvel_app_project.ui.pages.SingleHeroScreen

enum class HeroesScreen {
    Start,
    SingleHero
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()){

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