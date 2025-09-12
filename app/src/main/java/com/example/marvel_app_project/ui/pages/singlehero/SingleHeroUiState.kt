package com.example.marvel_app_project.ui.pages.singlehero

import com.example.marvel_app_project.models.ui.HeroUI

/**
 * [SingleHeroUiState] is a sealed interface that store all possible UI states for the SingleHeroScreen.
 * It transfers them from the ViewModel to UI inside 1 structure what is matches with the MVI pattern logic.
 * See about [MVI pattern](https://www.geeksforgeeks.org/software-engineering/model-view-intent-mvi-pattern-in-reactive-programming-a-comprehensive-overview/)
 *
 * @author Zyuzin Roman
 */

sealed interface SingleHeroUiState{
    data class Success(val singleHeroUIValue: HeroUI): SingleHeroUiState
    data class Error(val errorMessage:String, val reserveSingleHeroUiValue: HeroUI): SingleHeroUiState
    object Loading: SingleHeroUiState
}