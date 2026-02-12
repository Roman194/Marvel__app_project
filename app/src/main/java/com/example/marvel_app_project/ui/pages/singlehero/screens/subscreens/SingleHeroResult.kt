package com.example.marvel_app_project.ui.pages.singlehero.screens.subscreens

import androidx.compose.runtime.Composable
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.components.SingleHeroTextField
import com.example.marvel_app_project.ui.pages.HeroAction

/**
 * [SingleHeroResult] is a [Composable] component function that draws [SingleHeroScreen] in success state.
 * It shows a hero's image and details with a back button to return to the previous screen.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [SingleHeroResult], используется для отрисовки состояния успешной загрузки данных экрана [SingleHeroScreen].
 * Она выводит сообщение с конкретным героем из [SingleHeroResult]
 *
 * @see HeroAction
 * @see HeroUI
 * @author Zyuzin Roman
 */
@Composable
fun SingleHeroResult(hero: HeroUI, onAction: (HeroAction) -> Unit){

        SingleHeroTextField(
            hero = hero
        )

}