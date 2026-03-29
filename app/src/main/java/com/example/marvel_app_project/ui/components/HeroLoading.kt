package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Sizes.textFieldSpacing.vertical)
        ) {
            Image(
                painter = painterResource(id = R.drawable.loading_img),
                contentDescription = stringResource(id = R.string.loading),
                modifier = Modifier.size(Sizes.loadingLogo.size)
            )
            Text(
                text = stringResource(id = R.string.loading_text),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}
