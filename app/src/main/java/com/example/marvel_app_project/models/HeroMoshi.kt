package com.example.marvel_app_project.models

import androidx.compose.ui.graphics.Color
import com.squareup.moshi.Json

data class HeroMoshi(
    val id: String,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)


fun HeroMoshi.toUI(heroName: String, backgroundColor: Color) =
    HeroUI(
        name = heroName,
        description = description,
        image = thumbnail.path + "." +  thumbnail.extension,
        backgroundColor = backgroundColor
    )