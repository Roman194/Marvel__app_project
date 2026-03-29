package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun ErrorColumn(errorMessage: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(Spaces.errorPadding)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_connection_error),
            contentDescription = null,
            modifier = Modifier.size(Sizes.errorImageSize)
        )
        Text(
            text = errorMessage,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = MaterialTheme.colorScheme.onPrimary,
           modifier = Modifier.padding(top = Spaces.medium)
        )
    }
}
