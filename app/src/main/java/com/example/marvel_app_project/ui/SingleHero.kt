package com.example.marvel_app_project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel_app_project.R
import com.example.marvel_app_project.data.Heroes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily
import com.example.marvel_app_project.ui.theme.Sizes


@Composable
fun SingleHeroScreen(hero: Heroes, navigateUp: () -> Unit){
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
            Column(
                horizontalAlignment = AbsoluteAlignment.Left,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = Spaces.singleHeroTextColumn.start,
                        bottom = Spaces.singleHeroTextColumn.bottom,
                        end = Spaces.singleHeroTextColumn.end
                    )
            ) {
                Text(
                    text = hero.name,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = Sizes.fontSizes.heroNameInSingleScreen,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(
                    modifier = Modifier.size(
                        width = Spaces.spacer.standartWidth,
                        height = Spaces.spacer.standartHeight
                    )
                )
                Text(
                    text = hero.description,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = Sizes.fontSizes.heroDescription,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

        }
    }
}