package com.example.marvel_app_project.ui.pages.singlehero.screens.subscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.components.ErrorColumn
import com.example.marvel_app_project.ui.pages.HeroAction

/**
 * [SingleHeroError] is a [Composable] component function that draws [SingleHeroScreen] in error state.
 * It shows an error message and a hero from [SingleHeroResultHeroResult].
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [SingleHeroError], используется для отрисовки состояния ошибки экрана [SingleHeroScreen].
 * Она выводит сообщение с ошибкой и лист героев из [SingleHeroResult]
 * @see HeroAction
 * @see SingleHeroResult
 * @author Zyuzin Roman
 */
@Composable
fun SingleHeroError(
    errorMessage: String,
    hero: HeroUI,
    onAction: (HeroAction) -> Unit
){
    Column {
        ErrorColumn(
            errorMessage = errorMessage
        )

        SingleHeroResult(
            hero = hero,
            onAction = onAction
        )
    }
}