package com.example.marvel_app_project.ui.pages

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.models.HeroUI
import com.example.marvel_app_project.ui.HeroViewModel
import com.example.marvel_app_project.ui.HeroesUiState
import com.example.marvel_app_project.ui.components.ChooseHeroHeader
import com.example.marvel_app_project.ui.components.HeroCard
import com.example.marvel_app_project.ui.theme.Marvel_app_projectTheme
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces

@Composable
fun ChooseHeroScreen(
    heroesUiState: HeroesUiState,
    onHeroImageTaped:(String) -> Unit) {


    when(heroesUiState){
        is HeroesUiState.Loading -> ChooseHeroLoading()
        is HeroesUiState.Error -> ChooseHeroError(heroValues = heroesUiState.reserveHeroUiValues, onHeroImageTaped = onHeroImageTaped)
        is HeroesUiState.Success -> ChooseHeroResult(heroValues = heroesUiState.heroUIValues, onHeroImageTaped = onHeroImageTaped)
    }


}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseHeroResult(
    //heroViewModel: HeroViewModel = viewModel(),
    heroValues: List<HeroUI>,
    onHeroImageTaped:(String) -> Unit){

    //val heroValues by heroViewModel.heroUIState.collectAsState()
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

    //Text(text=listResult, color = MaterialTheme.colorScheme.onSecondary)

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

@Composable
fun ChooseHeroLoading(){
    Text(text = "loading...")
}

@Composable
fun ChooseHeroError(heroValues: List<HeroUI>, onHeroImageTaped:(String) -> Unit){



    Text(text = "Error: can't reach data from server")

    ChooseHeroResult(heroValues = heroValues, onHeroImageTaped = {onHeroImageTaped})
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Marvel_app_projectTheme {
        ChooseHeroResult(heroValues = SampleData.heroUISamples, onHeroImageTaped = {})
    }
}