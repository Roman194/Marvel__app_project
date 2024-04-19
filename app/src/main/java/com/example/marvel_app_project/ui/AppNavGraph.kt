package com.example.marvel_app_project.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroScreen
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroViewModel
import com.example.marvel_app_project.ui.pages.singlehero.SingleHeroScreen
import com.example.marvel_app_project.ui.pages.singlehero.SingleHeroViewModel

enum class HeroesScreen {
    Start,
    SingleHero
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()){

    val heroViewModel: ChooseHeroViewModel = viewModel()
    val singleHeroViewModel: SingleHeroViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = HeroesScreen.Start.name
    ) {
        composable(route = HeroesScreen.Start.name){
            ChooseHeroScreen(
                heroesUiState = heroViewModel.heroesUiState,
                onHeroImageTaped = {id, heroName ->
                    singleHeroViewModel.updateHeroForSingleHero(id = id, heroName = heroName)
                    navController.navigate(HeroesScreen.SingleHero.name)
                }
            )
        }
        composable(route = HeroesScreen.SingleHero.name){
            SingleHeroScreen(
                singleHeroUiState = singleHeroViewModel.singleHeroUIState,
                navigateUp = {navController.navigateUp()}
            )
        }
    }
}
