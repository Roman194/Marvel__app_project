package com.example.marvel_app_project

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
            modifier = Modifier.size(width = 192.dp, height = 41.dp)
        )
        Spacer(modifier = Modifier.size(1.dp, 25.dp))
        Text(
            text = "Choose your hero",
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.size(1.dp, 40.dp))
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data("https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg")
                .build(),
            contentDescription = "Deadpool",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp, 550.dp)
                .clip(RoundedCornerShape(12.dp))
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(12.dp),
                    ambientColor = Color(0,0,0, 25),
                    spotColor = Color(0,0,0, 25)
                )
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