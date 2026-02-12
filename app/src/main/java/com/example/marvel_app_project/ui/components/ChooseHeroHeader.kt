package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
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

//Github Copilot 2nd prompt 3rd attempt
/**
 * ErrorColumn-компонент должен занимать всю ширину экрана
 * !Ничего не исправил, хотя заявил, что исправил: галлюцинация!
 * На второй попытке по той же причине это не исправил
 */
/**
 * [ChooseHeroHeader] is a [Composable] component function that draws header for ChooseHeroScreen.
 */
@Composable
fun ChooseHeroHeader() {
    Column(
        modifier = Modifier
            .padding(vertical = Spaces.chooseHeroHeaderVertical),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.size(
                width = Sizes.marvelLogo.width,
                height = Sizes.marvelLogo.height
            )
        )

        Spacer(modifier = Modifier.height(Spaces.spacer.standardHeight))

        androidx.compose.material3.Text(
            text = stringResource(id = R.string.choose_hero),
            color = MaterialTheme.colorScheme.onPrimary,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.underLogoText
        )
    }
}
