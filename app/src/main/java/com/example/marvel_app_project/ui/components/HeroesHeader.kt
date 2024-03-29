package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun ChooseHeroHeader(){
    Image(
        painter = painterResource(id = R.drawable.marvel_logo),
        contentDescription = stringResource(id = R.string.marvel),
        modifier = Modifier.size(
            width = Sizes.marvelLogo.width,
            height = Sizes.marvelLogo.height
        )
    )
    Spacer(
        modifier = Modifier.size(
            width = Spaces.spacer.standartWidth,
            height = Spaces.spacer.extendedHeight
        )
    )
    Text(
        text = stringResource(id = R.string.choose_hero),
        fontFamily = interFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = Sizes.fontSizes.underLogoText,
        color = MaterialTheme.colorScheme.onSecondary
    )
    Spacer(
        modifier = Modifier.size(
            width = Spaces.spacer.standartWidth,
            height = Spaces.spacer.theMostExtendedHeight
        )
    )
}