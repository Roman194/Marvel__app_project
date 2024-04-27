package com.example.marvel_app_project.mappers

import androidx.compose.ui.graphics.Color
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.ui.HeroUI

fun HeroEntity.toUI(
    heroName: String,
    backgroundColor: Color
) = HeroUI(
    id = id,
    serverId = serverId,
    name = heroName,
    description = description,
    image = image,
    backgroundColor = backgroundColor
)

fun HeroEntity.toSingleUI() =
    HeroUI(
        id = id,
        serverId = serverId,
        name = name,
        description = description,
        image = image
    )