package com.example.marvel_app_project.ui.pages.choosehero.screens.subscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.components.ErrorColumn
import com.example.marvel_app_project.ui.pages.HeroAction

/**
 * [ChooseHeroError] is a [Composable] component function that draws [ChooseHeroScreen] in error state.
 * It shows an error message and a list of heroes from [ChooseHeroResult].
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [ChooseHeroError], используется для отрисовки состояния ошибки экрана [ChooseHeroScreen].
 * Она выводит сообщение с ошибкой и лист героев из [ChooseHeroResult]
 *
 * @see HeroAction
 * @see ChooseHeroResult
 * @author Zyuzin Roman
 */
@Composable
fun ChooseHeroError(
    errorMessage: String,
    heroValues: List<HeroUI>,
    onAction:(HeroAction) -> Unit
){
    Column {
        ErrorColumn(errorMessage = errorMessage)

        ChooseHeroResult(heroValues = heroValues, onAction = onAction)
    }
}