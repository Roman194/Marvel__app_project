package com.example.marvel_app_project.ui.pages.choosehero

import androidx.compose.runtime.Composable
import com.example.marvel_app_project.ui.components.HeroLoading
import com.example.marvel_app_project.ui.pages.choosehero.screens.ChooseHeroError
import com.example.marvel_app_project.ui.pages.choosehero.screens.ChooseHeroResult

@Composable
fun ChooseHeroScreen(
    heroesUiState: ChooseHeroesUiState,
    onHeroImageTaped:(Int, String) -> Unit) {

    when(heroesUiState){
        is ChooseHeroesUiState.Loading -> HeroLoading()
        is ChooseHeroesUiState.Error -> ChooseHeroError(
            errorMessage = heroesUiState.errorMessage,
            heroValues = heroesUiState.reserveHeroUiValues,
            onHeroImageTaped = onHeroImageTaped
        )
        is ChooseHeroesUiState.Success -> ChooseHeroResult(
            heroValues = heroesUiState.heroUIValues,
            onHeroImageTaped = onHeroImageTaped
        )
    }
}
