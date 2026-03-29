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

//Cline 2nd prompt 2nd attempt
/**
 * Есть ряд недочётов. В HeroLoading есть "зашитый" в коде текст. Возьми текст из string ресурсов
 * как ты делал в других функциях.  Текст в SingleHeroTextField должен быть выровнен по левому
 * нижнему краю. Также обрати внимание на HeroCard.kt. В нём в AsyncImage заявлена такая комбинация
 * параметров, которая не подходит ни к одной его реализации: либо каких-то не хватает, либо
 * Argument type mismatch: actual type is 'ImageRequest', but 'Painter?' was expected. Из-за этого
 * код не запускается. Исправь пожалуйста
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
