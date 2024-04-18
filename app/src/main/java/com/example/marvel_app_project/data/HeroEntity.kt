package com.example.marvel_app_project.data

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvel_app_project.models.UiLayer.HeroUI

@Entity
data class HeroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val serverId: String,
    val name: String,
    val description: String,
    val image: String,
)

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
