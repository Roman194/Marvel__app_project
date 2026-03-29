package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

//Cilo code 2nd prompt 3rd attempt
/**
 * Теперь в HeroLoading куда-то пропал Image. Исправь это пожалуйста
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = null,
            modifier = Modifier
                .height(Sizes.marvelLogo.height)
        )
        Spacer(modifier = Modifier.height(Spaces.chooseHeroHeader.logoToTextPadding))
        Text(
            text = stringResource(id = R.string.choose_hero),
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.underLogoText,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
