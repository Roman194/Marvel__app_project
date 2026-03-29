package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

/**
 * [SingleHeroTextField] is a [Composable] component function that draws text info for [SingleHeroScreen].
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [SingleHeroTextField], используемая для вывода текстовой инфорамции в [SingleHeroScreen].
 *
 * @author Zyuzin Roman
 */
@Composable
fun SingleHeroTextField(hero: HeroUI){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = Spaces.singleHeroTextColumn.start,
                bottom = Spaces.singleHeroTextColumn.bottom,
                end = Spaces.singleHeroTextColumn.end
            ),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = hero.name,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = Sizes.fontSizes.heroNameInSingleScreen,
                fontFamily = interFamily,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = hero.description,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = Sizes.fontSizes.heroDescription,
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
}