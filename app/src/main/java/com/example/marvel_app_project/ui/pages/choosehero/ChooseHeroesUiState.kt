package com.example.marvel_app_project.ui.pages.choosehero

import com.example.marvel_app_project.models.ui.HeroUI

sealed interface ChooseHeroesUiState{
    data class Success(val heroUIValues: List<HeroUI>): ChooseHeroesUiState
    data class Error(val errorMessage: String, val reserveHeroUiValues: List<HeroUI>): ChooseHeroesUiState
    object Loading: ChooseHeroesUiState
}