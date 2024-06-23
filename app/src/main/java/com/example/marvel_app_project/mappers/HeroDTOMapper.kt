package com.example.marvel_app_project.mappers

import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.network.HeroDTO

fun HeroDTO.toEntity() =
    HeroEntity(
        serverId = id,
        name = name,
        description = description,
        image = thumbnail.path + "." +  thumbnail.extension
    )