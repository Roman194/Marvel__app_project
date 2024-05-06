package com.example.marvel_app_project.ui.pages.singlehero

import androidx.compose.runtime.Composable
import com.example.marvel_app_project.ui.HeroAction
import com.example.marvel_app_project.ui.components.HeroLoading
import com.example.marvel_app_project.ui.pages.singlehero.screens.SingleHeroError
import com.example.marvel_app_project.ui.pages.singlehero.screens.SingleHeroResult


@Composable
fun SingleHeroScreen(singleHeroUiState: SingleHeroUiState, onAction: (HeroAction) -> Unit){

    when(singleHeroUiState){
        is SingleHeroUiState.Loading -> HeroLoading()
        is SingleHeroUiState.Success -> SingleHeroResult(
            hero = singleHeroUiState.singleHeroUIValue,
            onAction = onAction
        )
        is SingleHeroUiState.Error -> SingleHeroError(
            errorMessage = singleHeroUiState.errorMessage,
            hero = singleHeroUiState.reserveSingleHeroUiValue,
            onAction = onAction
        )
    }
}