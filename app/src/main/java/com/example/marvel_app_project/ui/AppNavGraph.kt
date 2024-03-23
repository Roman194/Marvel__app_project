package com.example.marvel_app_project.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_project.ui.pages.ChooseHeroScreen
import com.example.marvel_app_project.ui.pages.SingleHeroScreen

enum class HeroesScreen {
    Start,
    SingleHero
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()){

    val heroViewModel: HeroViewModel = viewModel()
    val singleHeroValue by heroViewModel.singleHeroUiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = HeroesScreen.Start.name
    ) {
        composable(route = HeroesScreen.Start.name){
            ChooseHeroScreen(
                onHeroImageTaped = {heroName ->
                    heroViewModel.updateHeroForSingleHero(heroName = heroName)
                    navController.navigate(HeroesScreen.SingleHero.name)
                }
            )
        }
        composable(route = HeroesScreen.SingleHero.name){
            SingleHeroScreen(
                hero = singleHeroValue,
                navigateUp = {navController.navigateUp()}
            )
        }
    }
}
