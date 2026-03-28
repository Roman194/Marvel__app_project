package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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

//Amazon q 2nd prompt 2nd attempt
/**
 * Круто! Но есть ряд недочётов. В HeroLoading есть "зашитый" в коде текст. Возьми текст из string
 * ресурсов как ты делал в других функциях. Также обрати внимание на ErrorColumn. Он не должен
 * занимать весь экран, а должен быть лишь полоской сверху над экраном, занимающей всю ширину экрана.
 * Текст в SingleHeroTextField должен быть выровнен по левому нижнему краю.
 */
/**
 * [HeroLoading] is a [Composable] component function that draws [ChooseHeroScreen] in loading state.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [HeroLoading], используемая для вывода заграузочного состояния в [ChooseHeroScreen].
 *
 * @see HeroAction
 * @author Zyuzin Roman
 */

@Composable
fun HeroLoading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.loading_img),
            contentDescription = null,
            modifier = Modifier.size(Sizes.loadingLogo.size)
        )
        Spacer(modifier = Modifier.height(Spaces.spacer.standardHeight))
        Text(
            text = stringResource(R.string.loading_text),
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun HeroLoadingPreview() {
    HeroLoading()
}
