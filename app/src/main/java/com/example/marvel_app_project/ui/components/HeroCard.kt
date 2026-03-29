package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
        modifier = Modifier.size(
            width = Sizes.heroCard.width,
            height = Sizes.heroCard.height
        ),
        shape = Shapes.large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = Spaces.shadowElevation
        ),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        onClick = {
            onAction(HeroAction.OnHeroImageTapped(hero.id, hero.serverId))
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = hero.image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.marvelcard_loading),
                error = painterResource(id = R.drawable.marvelcard_loadingerror)
            )

            Text(
                text = hero.name,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = Sizes.fontSizes.heroNameInCard,
                fontFamily = interFamily,
                fontWeight = FontWeight.ExtraBold,
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