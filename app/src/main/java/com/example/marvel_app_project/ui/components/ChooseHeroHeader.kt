package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

//Cascade 2nd prompt 2nd attempt
/**
 * Круто! Но обрати внимание на ErrorColumn. Он не должен занимать весь экран, а должен быть лишь
 * полоской сверху над экраном, занимающей всю ширину экрана
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Spaces.spacer.extendedHeight),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = null,
            modifier = Modifier
                .height(Sizes.marvelLogo.height)
                .padding(horizontal = 16.dp)
        )
        
        Spacer(
            modifier = Modifier
                .height(Spaces.spacer.standardHeight)
        )
        
        Text(
            text = stringResource(id = R.string.choose_hero),
            style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = interFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = Sizes.fontSizes.underLogoText,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}
