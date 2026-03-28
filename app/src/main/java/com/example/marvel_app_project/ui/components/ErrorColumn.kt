package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun ErrorColumn(errorMessage: String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(Spaces.errorColumn),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = null,
            modifier = Modifier.size(Sizes.noInternetLogo.size)
        )
        Spacer(modifier = Modifier.height(Spaces.spacer.standardHeight))
        Text(
            text = errorMessage,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = Sizes.fontSizes.responseError,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )
    }
}
