package com.example.marvel_app_project.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvel_app_project.models.data.HeroEntity


/**
 * This abstract class is the implementation of [RoomDatabase] with the usage of functions from the [HeroDao] interface
 *
 * Данный абстрактный класс является реализацией [RoomDatabase] с использованием функций из интерфейса [HeroDao]
 *
 * @see HeroDao for more info
 * @author Zyuzin Roman
 */
@Database(
    entities = [HeroEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao

}