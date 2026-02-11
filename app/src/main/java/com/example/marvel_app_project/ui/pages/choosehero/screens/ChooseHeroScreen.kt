package com.example.marvel_app_project.ui.pages.choosehero.screens

import androidx.compose.runtime.Composable
import com.example.marvel_app_project.ui.components.HeroLoading
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroesUiState
import com.example.marvel_app_project.ui.pages.choosehero.screens.subscreens.ChooseHeroError
import com.example.marvel_app_project.ui.pages.choosehero.screens.subscreens.ChooseHeroResult

/**
 * [ChooseHeroScreen] is a [Composable] component function that draws the main ChooseHeroScreen.
 * It uses [ChooseHeroesUiState] to show the current UI state: Loading, Error or Success.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [ChooseHeroScreen], используется для отрисовки основной части [ChooseHeroScreen].
 * Использует [ChooseHeroesUiState] для вывода текущего UI-состояния: Loading, Error or Success.
 *
 * @see ChooseHeroesUiState
 * @see HeroAction
 * @author Zyuzin Roman
 */
@Composable
fun ChooseHeroScreen(
    heroesUiState: ChooseHeroesUiState,
    onAction:(HeroAction) -> Unit) {

    when(heroesUiState){
        is ChooseHeroesUiState.Loading -> HeroLoading()
        is ChooseHeroesUiState.Error -> ChooseHeroError(
            errorMessage = heroesUiState.errorMessage,
            heroValues = heroesUiState.reserveHeroUiValues,
            onAction = onAction
        )
        is ChooseHeroesUiState.Success -> ChooseHeroResult(
            heroValues = heroesUiState.heroUIValues,
            onAction = onAction
        )
    }
}
