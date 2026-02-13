package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

//Github Copilot CL 2nd prompt 2nd attempt
/**
 * Работает! Но ErrorColumn не должен занимать весь экран. Эта лишь небольшая табличка над основным
 * функицоналом (Result). Однако она должна занимать всю выделяемую ей ширину. Исправь это. Также
 * удали ComponentPreviews, он не нужен по заданию
 */

/**
 * [ChooseHeroHeader] is a [Composable] component function that draws header for ChooseHeroScreen.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [ChooseHeroHeader], используемая для рисования заголовка в [ChooseHeroScreen].
 *
 * @author Zyuzin Roman
 */
@Composable
fun ChooseHeroHeader() {
    Column(
        modifier = Modifier.padding(bottom = Spaces.chooseHeroColumn),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(R.drawable.marvel_logo)
                .build(),
            contentDescription = stringResource(R.string.marvel),
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(
                width = Sizes.marvelLogo.width,
                height = Sizes.marvelLogo.height
            )
        )
        Spacer(modifier = Modifier.height(Spaces.spacer.standardHeight))
        Text(
            text = stringResource(R.string.choose_hero),
            fontSize = Sizes.fontSizes.underLogoText,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
