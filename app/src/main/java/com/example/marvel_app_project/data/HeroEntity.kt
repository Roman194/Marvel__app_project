package com.example.marvel_app_project.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
)
