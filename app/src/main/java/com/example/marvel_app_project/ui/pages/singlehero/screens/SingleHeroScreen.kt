package com.example.marvel_app_project.ui.pages.singlehero.screens

import androidx.compose.runtime.Composable
import com.example.marvel_app_project.ui.components.HeroLoading
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.pages.singlehero.SingleHeroUiState
import com.example.marvel_app_project.ui.pages.singlehero.screens.subscreens.SingleHeroError
import com.example.marvel_app_project.ui.pages.singlehero.screens.subscreens.SingleHeroResult


/**
 * [SingleHeroScreen] is a [Composable] component function that draws the main SingleHeroScreen.
 * It uses [SingleHeroUiState] to show the current UI state: Loading, Error or Success.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [SingleHeroScreen], используется для отрисовки основной части [SingleHeroScreen].
 * Использует [SibgleHeroUiState] для вывода текущего UI-состояния: Loading, Error or Success.
 *
 * @see SingleHeroUiState
 * @see HeroAction
 * @author Zyuzin Roman
 */
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