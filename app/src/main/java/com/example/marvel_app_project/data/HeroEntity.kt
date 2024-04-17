package com.example.marvel_app_project.data

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvel_app_project.models.UiLayer.HeroUI

@Entity
data class HeroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val image: String,
)

fun HeroEntity.toUI(
    backgroundColor: Color
) = HeroUI(
        id = id,
        name = name,
        description = description,
        image = image,
        backgroundColor = backgroundColor
    )

fun HeroEntity.toSingleUI() =
    HeroUI(
        id = id,
        name = name,
        description = description,
        image = image
    )
