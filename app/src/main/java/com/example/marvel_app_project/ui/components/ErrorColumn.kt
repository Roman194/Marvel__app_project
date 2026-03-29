package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.marvel_app_project.R
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun ErrorColumn(errorMessage: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            modifier = Modifier.padding(
                horizontal = Spaces.errorColumn,
                vertical = Spaces.errorColumn
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(Spaces.errorColumn)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_connection_error),
                    contentDescription = null,
                    modifier = Modifier.size(Sizes.noInternetLogo.size)
                )

                androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = Sizes.fontSizes.responseError,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}