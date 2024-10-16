package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun SingleHeroTextField(hero: HeroUI){
    Column(
        horizontalAlignment = Alignment.Start,
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
            color = MaterialTheme.colorScheme.onPrimary,
            style = LocalTextStyle.current.copy(textDirection = TextDirection.Content)
        )
        Spacer(
            modifier = Modifier.size(
                width = Spaces.spacer.standardWidth,
                height = Spaces.spacer.standardHeight
            )
        )
        Text(
            text = hero.description,
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Sizes.fontSizes.heroDescription,
            color = MaterialTheme.colorScheme.onPrimary,
            style = LocalTextStyle.current.copy(textDirection = TextDirection.Content)
        )
    }
}