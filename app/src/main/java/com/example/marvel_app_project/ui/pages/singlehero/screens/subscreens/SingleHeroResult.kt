package com.example.marvel_app_project.ui.pages.singlehero.screens.subscreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel_app_project.R
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.components.SingleHeroTextField
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces

@Composable
fun SingleHeroResult(hero: HeroUI, onAction: (HeroAction) -> Unit){
    Box (modifier = Modifier.fillMaxSize()){
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(hero.image)
                .build(),
            contentDescription = hero.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = Spaces.singleHeroColumn
                )
        ) {
            IconButton(
                onClick = {
                    onAction(HeroAction.OnBackToChooseHero)
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_arrow_back_24),
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(
                        width = Sizes.backIcon.width,
                        height = Sizes.backIcon.height
                    ),
                    contentDescription = stringResource(R.string.back_button)
                )
            }
            SingleHeroTextField(
                hero = hero
            )

        }
    }
}