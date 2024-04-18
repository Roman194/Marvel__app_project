package com.example.marvel_app_project.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_project.data.HeroDatabase
import com.example.marvel_app_project.domain.HeroRepository
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroScreen
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroViewModel
import com.example.marvel_app_project.ui.pages.singlehero.SingleHeroScreen
import com.example.marvel_app_project.ui.pages.singlehero.SingleHeroViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

enum class HeroesScreen {
    Start,
    SingleHero
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()){

    val applicationScope = CoroutineScope(SupervisorJob())
    val context = LocalContext.current
    val database by lazy {
        HeroDatabase.getDatabase(
            context = context,
            scope = applicationScope
        )
    }
    val repository by lazy {
        HeroRepository(database.heroDao())
    }

    val heroViewModel = ChooseHeroViewModel(repository = repository)
    val singleHeroViewModel = SingleHeroViewModel(repository = repository)

//    val heroViewModel: ChooseHeroViewModel = viewModel()
//    val singleHeroViewModel: SingleHeroViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = HeroesScreen.Start.name
    ) {
        composable(route = HeroesScreen.Start.name){
            ChooseHeroScreen(
                heroesUiState = heroViewModel.heroesUiState,
                onHeroImageTaped = {id, serverId ->
                    singleHeroViewModel.updateHeroForSingleHero(id = id, serverId = serverId)
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
