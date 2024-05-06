package com.example.marvel_app_project.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvel_app_project.models.data.HeroEntity

@Database(
    entities = [HeroEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao

}