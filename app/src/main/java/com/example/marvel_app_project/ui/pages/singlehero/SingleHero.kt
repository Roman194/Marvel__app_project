package com.example.marvel_app_project.ui.pages.singlehero

import androidx.compose.runtime.Composable
import com.example.marvel_app_project.ui.components.HeroLoading
import com.example.marvel_app_project.ui.pages.singlehero.screens.SingleHeroError
import com.example.marvel_app_project.ui.pages.singlehero.screens.SingleHeroResult


@Composable
fun SingleHeroScreen(singleHeroUiState: SingleHeroUiState, navigateUp: () -> Unit){

    when(singleHeroUiState){
        is SingleHeroUiState.Loading -> HeroLoading()
        is SingleHeroUiState.Success -> SingleHeroResult(
            hero = singleHeroUiState.singleHeroUIValue,
            navigateUp = navigateUp
        )
        is SingleHeroUiState.Error -> SingleHeroError(
            errorMessage = singleHeroUiState.errorMessage,
            hero = singleHeroUiState.reserveSingleHeroUiValue,
            navigateUp = navigateUp
        )
    }
}