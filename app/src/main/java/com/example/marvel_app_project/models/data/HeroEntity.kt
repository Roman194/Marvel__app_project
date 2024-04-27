package com.example.marvel_app_project.models.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val serverId: String,
    val name: String,
    val description: String,
    val image: String,
)
