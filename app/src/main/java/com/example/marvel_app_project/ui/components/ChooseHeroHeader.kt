package com.example.marvel_app_project.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.interFamily
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource

//Lingma 2nd prompt 2nd attempt
/**
 * Код не запускается. Используй пожалуйста числовые данные, соответствующие реальным объектам из
 * папки theme. Также ты всё езё не реализовал SingleHeroTextField
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = Spaces.large)
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = null,
            modifier = Modifier.size(Sizes.logoSize)
        )
        Text(
            text = stringResource(R.string.choose_hero),
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
