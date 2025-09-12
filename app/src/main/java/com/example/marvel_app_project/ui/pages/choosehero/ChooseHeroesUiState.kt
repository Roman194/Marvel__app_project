package com.example.marvel_app_project.ui.pages.choosehero

import com.example.marvel_app_project.models.ui.HeroUI

/**
 * [ChooseHeroesUiState] is a sealed interface that store all possible UI states for the ChooseHeroScreen.
 * It transfers them from the ViewModel to UI inside 1 structure what is matches with the MVI pattern logic.
 * See about [MVI pattern](https://www.geeksforgeeks.org/software-engineering/model-view-intent-mvi-pattern-in-reactive-programming-a-comprehensive-overview/)
 *
 * @author Zyuzin Roman
 */

sealed interface ChooseHeroesUiState{
    data class Success(val heroUIValues: List<HeroUI>): ChooseHeroesUiState
    data class Error(val errorMessage: String, val reserveHeroUiValues: List<HeroUI>): ChooseHeroesUiState
    object Loading: ChooseHeroesUiState
}