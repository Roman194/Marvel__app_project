package com.example.marvel_app_project

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel_app_project.data.Heroes
import com.example.marvel_app_project.ui.theme.interFamily

@Composable
fun HeroCard(hero: Heroes){
    Box{
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(hero.image)
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
        Text(
            text = hero.name,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start= 30.dp, bottom =  45.dp)
        )
    }
}