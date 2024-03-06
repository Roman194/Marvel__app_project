package com.example.marvel_app_project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.ui.theme.Marvel_app_projectTheme
import com.example.marvel_app_project.ui.theme.interFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseHeroScreen() {

    val heroValues = SampleData.heroesSample
    val lazyListState = rememberLazyListState()
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = "Marvel studios",
            modifier = Modifier.size(width = 192.dp, height = 41.dp)
        )
        Spacer(modifier = Modifier.size(1.dp, 25.dp))
        Text(
            text = "Choose your hero",
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.size(1.dp, 40.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(48.dp),
            state = lazyListState,
            flingBehavior = snapBehavior
        ){
            items(heroValues){ hero ->
                HeroCard(hero)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Marvel_app_projectTheme {
        ChooseHeroScreen()
    }
}