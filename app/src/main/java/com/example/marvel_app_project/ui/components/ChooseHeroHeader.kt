package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

//Qodo 2nd prompt 1st attempt
/**
 * Во время выполнения промпта закончились кредиты бесплатного плана, поэтому генерация не была завершена.
 * Принял решение не учитывать эти изменения и не портить оценку Qodo за недоделанные изменения, так как
 * это нетехнический косяк а бизнес-задачный. :)
 * В заданиях 2 и 3 AI_агент Qoda не будет рассматриваться
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
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(top = Spaces.header.top, bottom = Spaces.header.bottom),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(
                width = Sizes.marvelLogo.width,
                height = Sizes.marvelLogo.height
            ),
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = stringResource(id = R.string.marvel)
        )

        Spacer(modifier = Modifier.height(Spaces.header.spacerBetweenLogoAndText))

        Text(
            text = stringResource(id = R.string.choose_hero),
            modifier = Modifier.padding(horizontal = Spaces.header.horizontalPadding),
            color = MaterialTheme.colorScheme.onPrimary,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.underLogoText,
            textAlign = TextAlign.Center
        )
    }
}
