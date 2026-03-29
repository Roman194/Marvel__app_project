package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces

//Cline 2nd prompt 3rd attempt
/**
 * Код запустился, но всё ещё есть ряд недочётов. Во-первых, SingleHeroTextField всё ещё выводится в
 * левом верхнем углу, а не нижнем. Также компонент HeroLoading выводится сверху по центру, а должен
 * по центру вертикали и горизонтали. ErrorColumn имеет ьесцветный фон, а должен иметь фон
 * MaterialTheme.colorScheme.secondary. В HeroCard в AsyncImage отсутствуют изображения на время
 * загрузки и на случай ошибки: R.drawable.marvelcard_loading и R.drawable.marvelcard_loadingerror
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
            .padding(top = Spaces.chooseHeroColumn),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spaces.spacer.standardHeight)
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.size(
                width = Sizes.logoSize.width,
                height = Sizes.logoSize.height
            )
        )
        Text(
            text = stringResource(id = R.string.choose_hero),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
