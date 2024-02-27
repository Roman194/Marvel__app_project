package com.example.marvel_app_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvel_app_project.ui.theme.Marvel_app_projectTheme

@Composable
fun ChooseHeroScreen() {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = "Marvel studios",
            modifier = Modifier.size(width = 180.dp, height = 50.dp)
        )
        Spacer(modifier = Modifier.size(1.dp, 25.dp))
        Text(
            text = "Choose your hero",
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Marvel_app_projectTheme {
        ChooseHeroScreen()
    }
}