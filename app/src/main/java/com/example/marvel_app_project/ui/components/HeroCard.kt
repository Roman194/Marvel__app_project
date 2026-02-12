package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.Shapes
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
    val cardWidth = if (/* isLandscape not available here, use portrait size by default */ false) Sizes.heroCardLandscape.width else Sizes.heroCard.width
    val cardHeight = if (false) Sizes.heroCardLandscape.height else Sizes.heroCard.height

    Card(
        modifier = Modifier
            .width(cardWidth)
            .height(cardHeight)
            .clickable {
                onAction(HeroAction.OnHeroImageTapped(hero.id, hero.serverId))
            },
        shape = Shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = Spaces.shadowElevation)
    ){
        Box(modifier = Modifier.fillMaxSize()){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hero.image)
                    .crossfade(true)
                    .build(),
                contentDescription = hero.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            androidx.compose.material3.Text(
                text = hero.name,
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = interFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = Sizes.fontSizes.heroNameInCard,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = Spaces.heroCardText.start, bottom = Spaces.heroCardText.bottom, end = Spaces.heroCardText.end)
            )
        }
    }
}