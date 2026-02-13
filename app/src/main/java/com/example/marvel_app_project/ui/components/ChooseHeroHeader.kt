package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

//Koda 2nd prompt 3rd attempt
/**
 * Содержимое SingleHeroTextField должно отображаться в левом нижнему углу. ChooseHeroHeader должен
 * иметь некоторое "пространство" после себя, чтобы не сливаться с элементами, идущими ниже него.
 * Также в HeroCard нужно увеличить размер имени героев
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
        modifier = Modifier.padding(bottom = Spaces.chooseHeroHeader.bottomPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = null,
            modifier = Modifier
                .width(Sizes.marvelLogo.width)
                .height(Sizes.marvelLogo.height)
        )
        Spacer(modifier = Modifier.height(Spaces.chooseHeroHeader.logoToTextPadding))
        Text(
            text = stringResource(id = R.string.choose_hero),
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
