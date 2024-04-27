package com.example.marvel_app_project.mappers

import androidx.compose.ui.graphics.Color
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.network.HeroDTO
import com.example.marvel_app_project.models.ui.HeroUI

fun HeroDTO.toEntity() =
    HeroEntity(
        serverId = id,
        name = name,
        description = description,
        image = thumbnail.path + "." +  thumbnail.extension
    )

fun HeroDTO.toUI(
    heroName: String,
    backgroundColor: Color
) =
    HeroUI(
        id = id.toInt(),
        name = if(id.toInt() < 100) name else heroName,
        image = thumbnail.path + "." +  thumbnail.extension,
        backgroundColor = backgroundColor
    )

fun HeroDTO.toSingleUI() =
    HeroUI(
        id = id.toInt(),
        name = name,
        description = description,
        image = thumbnail.path + "." +  thumbnail.extension
    )