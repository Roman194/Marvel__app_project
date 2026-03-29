package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
 * [ErrorColumn] is a [Composable] component function that draws error state for both screens.
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [ErrorColumn], используемая для вывода состояния ошибки для обоих экранов.
 *
 * @author Zyuzin Roman
 */
@Composable
fun ErrorColumn(errorMessage: String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Sizes.textFieldSpacing.vertical)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = stringResource(id = R.string.connection_error),
            modifier = Modifier.size(Sizes.noInternetLogo.size)
        )
        Text(
            text = errorMessage,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
