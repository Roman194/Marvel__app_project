package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.theme.Spaces

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
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = Spaces.singleHeroTextColumn.start,
                bottom = Spaces.singleHeroTextColumn.bottom,
                end = Spaces.singleHeroTextColumn.end
            ),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = hero.name,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(bottom = Spaces.spacer.smallerHeight)
        )
        Text(
            text = hero.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
