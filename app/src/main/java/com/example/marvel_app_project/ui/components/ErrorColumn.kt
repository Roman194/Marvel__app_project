package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

/**
 * [ErrorColumn] is a [Composable] component function that draws error state for screens.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [ErrorColumn], используемая для вывода состояния ошибки на экранах.
 *
 * @author Zyuzin Roman
 */
@Composable
fun ErrorColumn(errorMessage: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(Spaces.errorColumn),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = stringResource(id = R.string.connection_error),
            modifier = Modifier.size(Sizes.noInternetLogo.size)
        )
        Spacer(modifier = Modifier.width(Spaces.spacer.standardHeight))
        Text(
            text = errorMessage,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.responseError,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}