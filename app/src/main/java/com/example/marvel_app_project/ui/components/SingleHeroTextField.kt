package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

//Sweep 2nd prompt 2nd attempt
/**
 * Круто! Но обрати внимание на ErrorColumn. Он не должен занимать весь экран, а должен быть лишь
 * полоской сверху над экраном, занимающей всю ширину экрана. Текст в SingleHeroTextField должен
 * быть выровнен по левому нижнему краю, но на текущий момент он сверху слева. Исправь пожалуйста
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
fun SingleHeroTextField(hero: HeroUI) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier.padding(
                start = Spaces.singleHeroTextColumn.start,
                bottom = Spaces.singleHeroTextColumn.bottom,
                end = Spaces.singleHeroTextColumn.end
            )
        ) {
            Text(
                text = hero.name,
                fontFamily = interFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = Sizes.fontSizes.heroNameInSingleScreen,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(Spaces.spacer.smallerHeight))
            Text(
                text = hero.description,
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                fontSize = Sizes.fontSizes.heroDescription,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}