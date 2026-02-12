package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = Spaces.singleHeroTextColumn.start, end = Spaces.singleHeroTextColumn.end, bottom = Spaces.singleHeroTextColumn.bottom),
        verticalArrangement = Arrangement.Bottom
    ){
        androidx.compose.material3.Text(
            text = hero.name,
            color = MaterialTheme.colorScheme.onPrimary,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.heroNameInSingleScreen
        )

        Spacer(modifier = Modifier.height(8.dp))

        androidx.compose.material3.Text(
            text = hero.description,
            color = MaterialTheme.colorScheme.onPrimary,
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Sizes.fontSizes.heroDescription
        )
    }
}