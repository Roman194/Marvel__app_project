package com.example.marvel_app_project.ui.pages.choosehero.screens.subscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.marvel_app_project.R
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.pages.HeroAction
import com.example.marvel_app_project.ui.theme.Shapes
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun ChooseHeroError(
    errorMessage: String,
    heroValues: List<HeroUI>,
    onAction:(HeroAction) -> Unit
){
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Spaces.errorColumn)
                .clip(Shapes.medium)
                .background(color = MaterialTheme.colorScheme.secondary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(Sizes.noInternetLogo.size),
                painter = painterResource(id = R.drawable.ic_connection_error),
                contentDescription = stringResource(R.string.connection_error)
            )
            Spacer(
                modifier = Modifier.size(
                    Spaces.spacer.standardWidth,
                    Spaces.spacer.smallerHeight
                )
            )
            Text(
                text = errorMessage + stringResource(R.string.choosehero_error_message),
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                fontSize = Sizes.fontSizes.responseError,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }

        ChooseHeroResult(heroValues = heroValues, onAction = onAction)
    }
}