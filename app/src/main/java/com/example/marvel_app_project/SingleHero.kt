package com.example.marvel_app_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SingleHeroScreen(navigateUp: () -> Unit){
    Column {
        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(width = 28.dp, height = 32.dp),
                contentDescription = "Back"//stringResource(R.string.back_button)
            )
        }
        Text(text = "Single hero screen")
    }
}