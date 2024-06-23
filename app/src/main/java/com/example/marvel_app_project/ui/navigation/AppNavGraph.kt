package com.example.marvel_app_project.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroViewModel
import com.example.marvel_app_project.ui.pages.choosehero.screens.ChooseHeroScreen
import com.example.marvel_app_project.ui.pages.singlehero.SingleHeroViewModel
import com.example.marvel_app_project.ui.pages.singlehero.screens.SingleHeroScreen

enum class HeroesScreen {
    Start,
    SingleHero
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), heroId: Int){

    val heroViewModel = hiltViewModel<ChooseHeroViewModel>()
    val singleHeroViewModel = hiltViewModel<SingleHeroViewModel>()

    val startDestination: String
    if(heroId > 0){
        startDestination = HeroesScreen.SingleHero.name
        singleHeroViewModel.onAction(
            HeroAction.OnHeroNotificationTapped(heroId = heroId)
        )
    }
    else
        startDestination = HeroesScreen.Start.name
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = HeroesScreen.Start.name){
            ChooseHeroScreen(
                heroesUiState = heroViewModel.heroesUiState,
                onAction = { action ->
                    singleHeroViewModel.onAction(action)
                    navController.navigate(HeroesScreen.SingleHero.name)
                }
            )
        }
        composable(route = HeroesScreen.SingleHero.name){
            SingleHeroScreen(
                singleHeroUiState = singleHeroViewModel.singleHeroUIState,
                onAction = {action ->
                    val isSuccessfulNavigateUp = navController.navigateUp()
                    if(!isSuccessfulNavigateUp)
                        navController.navigate(HeroesScreen.Start.name)

                    singleHeroViewModel.onAction(action)
                }
            )
        }
    }
}
