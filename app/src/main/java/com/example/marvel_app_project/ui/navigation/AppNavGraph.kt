package com.example.marvel_app_project.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_project.ui.navigation.HeroesScreen.SingleHero
import com.example.marvel_app_project.ui.navigation.HeroesScreen.Start
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroViewModel
import com.example.marvel_app_project.ui.pages.choosehero.screens.ChooseHeroScreen
import com.example.marvel_app_project.ui.pages.singlehero.SingleHeroViewModel
import com.example.marvel_app_project.ui.pages.singlehero.screens.SingleHeroScreen

/**
 * [HeroesScreen] is enum class that shows current navigation state between 2 possible ones: [Start] and [SingleHero].
 * Start is connected with ChooseHeroScreen, SingleHero - with SingleHeroScreen
 */
enum class HeroesScreen {
    Start,
    SingleHero
}

/**
 * [AppNavGraph] function creates the main navigation menu between screens.
 *
 * @param navController sets [NavHostController] to manage navigation between screens
 * @param heroId is used to choose startDestination
 *
 * @see ChooseHeroViewModel
 * @see SingleHeroViewModel
 * @see ChooseHeroScreen
 * @see SingleHeroScreen
 *
 * @author Zyuzin Roman
 */

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), heroId: Int){
    /**
     * heroViewModel and singleHeroViewModel are used to create the instance of [ChooseHeroViewModel] and [SingleHeroViewModel]
     * with the usage of [hiltViewModel] from Dagger Hilt DI lib.
     * About Dagger Hilt, see [this video](https://www.youtube.com/live/yGiCNunSVN8?si=2q-cqxnb3kFm4D50)
     */

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

    /**
     * [NavHost] is a function that manages destinations between composable screens
     *
     * @property navController described higher
     * @property startDestination set the default screen when activity is loaded
     */
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        /**
         * [ChooseHeroScreen] function creates ChooseHero UI for that screen.
         * As a route it uses Start from [HeroesScreen] enum class.
         *
         * @param heroesUiState links [ChooseHeroViewModel] with UI of this screen to manage screen Ui state from its view model
         * @param onAction describes which actions should be done in [ChooseHeroViewModel] when user triggers navigate to [SingleHeroScreen]
         */
        composable(route = HeroesScreen.Start.name){
            ChooseHeroScreen(
                heroesUiState = heroViewModel.heroesUiState,
                onAction = { action ->
                    singleHeroViewModel.onAction(action)
                    navController.navigate(HeroesScreen.SingleHero.name)
                }
            )
        }

        /**
         * [SingleHeroScreen] function creates SingleHero UI for that screen.
         * As a route it uses SingleHero from [HeroesScreen] enum class.
         *
         * @param singleHeroUiState links [SingleHeroViewModel] with UI of this screen to manage screen Ui state from its view model
         * @param onAction triggers actions that should be done onAction in [SingleHeroViewModel] when user triggers navigate back to [ChooseHeroScreen]
         */
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
