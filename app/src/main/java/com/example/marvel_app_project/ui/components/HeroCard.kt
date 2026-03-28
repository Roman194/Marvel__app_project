package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.marvel_app_project.ui.utils.isLandscape

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
    val cardWidth =
        if (isLandscape()) Sizes.heroCardLandscape.width else Sizes.heroCard.width
    val cardHeight =
        if (isLandscape()) Sizes.heroCardLandscape.height else Sizes.heroCard.height
    val nameFontSize =
        if (isLandscape()) Sizes.fontSizes.heroNameInCardLandscape else Sizes.fontSizes.heroNameInCard

    Box(
        modifier = Modifier
            .size(width = cardWidth, height = cardHeight)
            .shadow(Spaces.shadowElevation, Shapes.large)
            .clip(Shapes.large)
            .clickable {
                onAction(HeroAction.OnHeroImageTapped(hero.id, hero.serverId))
            }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(hero.image)
                .build(),
            placeholder = painterResource(R.drawable.marvelcard_loading),
            error = painterResource(R.drawable.marvelcard_loadingerror),
            contentDescription = hero.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = hero.name,
            fontSize = nameFontSize,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
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
