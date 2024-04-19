package com.example.marvel_app_project.ui.pages.singlehero

import com.example.marvel_app_project.models.ui.HeroUI

sealed interface SingleHeroUiState{
    data class Success(val singleHeroUIValue: HeroUI): SingleHeroUiState
    data class Error(val errorMessage:String, val reserveSingleHeroUiValue: HeroUI): SingleHeroUiState
    object Loading: SingleHeroUiState
}