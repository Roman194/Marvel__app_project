package com.example.marvel_app_project.ui.pages.singlehero.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel_app_project.R
import com.example.marvel_app_project.models.UiLayer.HeroUI
import com.example.marvel_app_project.ui.components.SingleHeroTextField
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces

@Composable
fun SingleHeroResult(hero: HeroUI, navigateUp: () -> Unit){
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
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.size(
                        width = Sizes.backIcon.width,
                        height = Sizes.backIcon.height
                    ),
                    contentDescription = stringResource(R.string.back_button)
                )
            }
            SingleHeroTextField(hero = hero)

        }
    }
}