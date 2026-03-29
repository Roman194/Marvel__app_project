package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun SingleHeroTextField(hero: HeroUI) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spaces.heroDetailsPadding)
    ) {
        Text(
            text = hero.name,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize =MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = hero.description,
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier =Modifier.padding(top = Spaces.small)
        )
    }
}
