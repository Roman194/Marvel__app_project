package com.example.marvel_app_project.models.data.network

import androidx.compose.ui.graphics.Color
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.ui.HeroUI

data class HeroMoshi(
    val id: String,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)


fun HeroMoshi.toEntity() =
    HeroEntity(
        serverId = id,
        name = name,
        description = description,
        image = thumbnail.path + "." +  thumbnail.extension
    )

fun HeroMoshi.toUI(
    heroName: String,
    backgroundColor: Color
) =
    HeroUI(
        id = id.toInt(),
        name = if(id.toInt() < 100) name else heroName,
        image = thumbnail.path + "." +  thumbnail.extension,
        backgroundColor = backgroundColor
    )

fun HeroMoshi.toSingleUI() =
    HeroUI(
        id = id.toInt(),
        name = name,
        description = description,
        image = thumbnail.path + "." +  thumbnail.extension
    )