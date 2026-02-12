package com.example.marvel_app_project.ui.pages.choosehero.screens.subscreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.components.ChooseHeroHeader
import com.example.marvel_app_project.ui.components.HeroCard
import com.example.marvel_app_project.ui.pages.HeroAction

/**
 * [ChooseHeroResult] is a [Composable] component function that draws [ChooseHeroScreen] in success state.
 * It shows a list of heroes in a horizontally scrolling list with snapping behavior.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [ChooseHeroResult], используется для отрисовки состояния успешной загрузки данных экрана [ChooseHeroScreen].
 * Она выводит сообщение с листом героев из [ChooseHeroResult]
 *
 * @see HeroAction
 * @see HeroUI
 * @author Zyuzin Roman
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseHeroResult(
    heroValues: List<HeroUI>,
    onAction:(HeroAction) -> Unit){

    //Место для управления скроллом и цветам прямоугольника

    ChooseHeroHeader()

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ){
        items(heroValues){ hero ->
            HeroCard(
                hero,
                onAction
            )
        }
    }
}