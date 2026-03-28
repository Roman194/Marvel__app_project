package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

//Cascade 2nd prompt 3rd attempt
/**
 * Текст в SingleHeroTextField должен быть выровнен по левому нижнему краю, но на текущий момент он
 * сверху слева. Исправь пожалуйста
 */
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
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Spaces.singleHeroTextColumn.start,
                    bottom = Spaces.singleHeroTextColumn.bottom,
                    end = Spaces.singleHeroTextColumn.end
                )
                .align(Alignment.BottomStart),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = hero.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = Sizes.fontSizes.heroNameInSingleScreen,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
            
            Spacer(
                modifier = Modifier
                    .height(Spaces.spacer.smallerHeight)
            )
            
            Text(
                text = hero.description,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = Sizes.fontSizes.heroDescription,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }
}