package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun HeroLoading(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Image(
            modifier = Modifier.size(Sizes.loadingLogo.size),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
        Spacer(
            modifier = Modifier.size(
                Spaces.spacer.standartWidth,
                Spaces.spacer.smallerHeight
            )
        )
        Text(
            text = stringResource(R.string.loading_text),
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.underLogoText,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Preview
@Composable
fun HeroLoadingPreview(){
    HeroLoading()
}