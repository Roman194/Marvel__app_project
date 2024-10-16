package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.text.style.TextDirection
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

@Composable
fun HeroCard(hero: HeroUI, onAction:(HeroAction) -> Unit){
    Box(
        modifier = Modifier
            .clickable {
                onAction(
                    HeroAction.OnHeroImageTapped(
                        hero.id,
                        hero.serverId
                    )
                )
            }
            .size(
                width =
                if (isLandscape())
                    Sizes.heroCardLandscape.width
                else
                    Sizes.heroCard.width,
                height =
                if (isLandscape())
                    Sizes.heroCardLandscape.height
                else
                    Sizes.heroCard.height
            )
            .shadow(
                elevation = Spaces.shadowElevation,
                shape = Shapes.medium,
                ambientColor = MaterialTheme.colorScheme.onBackground,
                spotColor = MaterialTheme.colorScheme.onBackground
            )
    ){
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(hero.image)
                .build(),
            contentDescription = hero.name,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.marvelcard_loading),
            error = painterResource(id = R.drawable.marvelcard_loadingerror),
            modifier = Modifier
                .fillMaxSize()
                .clip(Shapes.medium)
        )
        Text(
            text = hero.name,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize =
            if(isLandscape())
                Sizes.fontSizes.heroNameInCardLandscape
            else
                Sizes.fontSizes.heroNameInCard,
            color = MaterialTheme.colorScheme.onPrimary,
            style = LocalTextStyle.current.copy(textDirection = TextDirection.Content),
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