package com.example.marvel_app_project.ui.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel_app_project.R
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.ui.components.ChooseHeroHeader
import com.example.marvel_app_project.ui.components.HeroCard
import com.example.marvel_app_project.ui.theme.Marvel_app_projectTheme
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseHeroScreen(onHeroImageTaped:(String) -> Unit) {

    val heroValues = SampleData.heroUISamples
    val lazyListState = rememberLazyListState()
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)
    val rectangleColorState = remember {
        mutableStateOf(Color(119, 3,8))
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
                    horizontal = Spaces.chooseHeroLazyRow.horizontalPadding
                ),
                horizontalArrangement = Arrangement.spacedBy(
                    space = Spaces.chooseHeroLazyRow.horizontalArrangement
                ),
                state = lazyListState,
                flingBehavior = snapBehavior
            ){
                items(heroValues){ hero ->
                    HeroCard(
                        hero,
                        onHeroImageTaped
                    )
                }
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Marvel_app_projectTheme {
        ChooseHeroScreen(onHeroImageTaped = {})
    }
}