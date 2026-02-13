package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Drawables
import com.example.marvel_app_project.ui.theme.interFamily

/**
 * [HeroLoading] is a [Composable] component function that draws [ChooseHeroScreen] in loading state.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [HeroLoading], используемая для вывода заграузочного состояния в [ChooseHeroScreen].
 *
 * @see HeroAction
 * @author Zyuzin Roman
 */

@Composable
fun HeroLoading(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Drawables.loadingImg.resourceAt()
        Text(
            text = R.string.loading_text.resource(),
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun HeroLoadingPreview(){
    HeroLoading()
}