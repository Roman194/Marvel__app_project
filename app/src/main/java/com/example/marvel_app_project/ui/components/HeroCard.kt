package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.theme.Drawables
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

/**
 * [HeroCard] is a [Composable] component function that draws hero card component for [ChooseHeroScreen].
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [HeroCard], используемая для рисования карточки героя в [ChooseHeroScreen].
 *
 * @author Zyuzin Roman
 */

@Composable
fun HeroCard(hero: HeroUI, onAction:(HeroAction) -> Unit){
    Card(
        modifier = Modifier
            .size(Sizes.heroCard.width, Sizes.heroCard.height)
            .clickable { onAction(HeroAction.OnHeroImageTapped(hero)) },
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(Spaces.shadowElevation)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = hero.image,
                contentDescription = null,
                placeholder = Drawables.marvelCardLoading,
                error = Drawables.marvelCardLoadingError,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = Spaces.heroCardText.start,
                        bottom = Spaces.heroCardText.bottom,
                        end = Spaces.heroCardText.end
                    ),
                verticalArrangement = Arrangement.spacedBy(Spaces.spacer.smallerHeight)
            ) {
                Text(
                    text = hero.name,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = Sizes.fontSizes.heroNameInCard
                )
            }
        }
    }
}