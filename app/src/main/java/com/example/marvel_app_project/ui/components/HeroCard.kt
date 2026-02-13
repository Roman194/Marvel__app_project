package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel_app_project.R
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.theme.Shapes
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
        shape = Shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = Spaces.shadowElevation),
        modifier = Modifier
            .size(width = Sizes.heroCard.width, height = Sizes.heroCard.height)
            .clickable { onAction(HeroAction.OnHeroImageTapped(hero.id, hero.serverId)) }
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hero.image)
                    .crossfade(true)
                    .placeholder(R.drawable.marvelcard_loading)
                    .error(R.drawable.marvelcard_loadingerror)
                    .build(),
                contentDescription = hero.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = Sizes.heroCard.width, height = Sizes.heroCard.height)
            )
            Text(
                text = hero.name,
                fontFamily = interFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = Sizes.fontSizes.heroNameInCard,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = Spaces.heroCardText.start,
                        bottom = Spaces.heroCardText.bottom,
                        end = Spaces.heroCardText.end
                    )
            )
        }
    }
}