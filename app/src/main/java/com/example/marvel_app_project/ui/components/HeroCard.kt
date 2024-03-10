package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import com.example.marvel_app_project.models.Heroes
import com.example.marvel_app_project.ui.theme.Shapes
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun HeroCard(hero: Heroes, onHeroImageTaped:(Heroes) -> Unit){
    Box(
        modifier = Modifier.clickable{ onHeroImageTaped(hero)}
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
                .size(
                    width = Sizes.heroCard.width,
                    height = Sizes.heroCard.height
                    )
                .clip(Shapes.medium)
                .shadow(//why shadow doesn't work at all?
                    elevation = Spaces.shadowElevation,
                    shape = Shapes.medium,
                    ambientColor = MaterialTheme.colorScheme.onBackground,
                    spotColor = MaterialTheme.colorScheme.onBackground
                )
        )
        Text(
            text = hero.name,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.heroNameInCard,
            color = MaterialTheme.colorScheme.onSecondary,
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