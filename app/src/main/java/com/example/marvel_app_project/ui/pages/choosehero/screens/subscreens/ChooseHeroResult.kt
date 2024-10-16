package com.example.marvel_app_project.ui.pages.choosehero.screens.subscreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.components.ChooseHeroHeader
import com.example.marvel_app_project.ui.components.HeroCard
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.utils.isLandscape

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseHeroResult(
    heroValues: List<HeroUI>,
    onAction:(HeroAction) -> Unit){

    val lazyListState = rememberLazyListState()
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)
    val rectangleColorState = remember {
        mutableStateOf(Color(0xFF770308))
    }
    val latestIndex = remember {
        mutableStateOf(lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index)
    }

    if(latestIndex.value != lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index){

        val firstVisibleIndex = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()?.index ?: -1
        val lastVisibleIndex = lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1

        if(firstVisibleIndex != -1){
            if(firstVisibleIndex == 0 && lastVisibleIndex == 1){
                rectangleColorState.value = heroValues[firstVisibleIndex].backgroundColor
            }else{
                rectangleColorState.value = heroValues[firstVisibleIndex + 1].backgroundColor
            }
        }
    }

    Box (modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ){
            Canvas(
                modifier = Modifier.size(
                    width = Sizes.rectanglesSizes.width,
                    height = Sizes.rectanglesSizes.height
                )
            ) {
                val path = Path().apply {
                    val width = size.width
                    val height = size.height
                    moveTo(width, 0f)
                    lineTo(0f, height)
                    lineTo(width, height)
                    close()
                }
                drawPath(path, rectangleColorState.value)
            }
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = Spaces.chooseHeroColumn
                )
        ){
            ChooseHeroHeader()

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(
                    horizontal =
                    if(isLandscape())
                        Spaces.chooseHeroLazyRowLandscape.horizontalPadding
                    else
                        Spaces.chooseHeroLazyRow.horizontalPadding
                ),
                horizontalArrangement = Arrangement.spacedBy(
                    space =
                    if(isLandscape())
                        Spaces.chooseHeroLazyRowLandscape.horizontalArrangement
                    else
                        Spaces.chooseHeroLazyRow.horizontalArrangement
                ),
                state = lazyListState,
                flingBehavior = snapBehavior
            ){
                items(heroValues){ hero ->
                    HeroCard(
                        hero,
                        onAction
                    )
                }
            }

        }
    }
}