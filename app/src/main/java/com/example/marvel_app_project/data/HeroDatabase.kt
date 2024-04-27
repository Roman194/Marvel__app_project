package com.example.marvel_app_project.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvel_app_project.models.data.HeroEntity

@Database(
    entities = [HeroEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao

    companion object{
        @Volatile
        private var INSTANCE: HeroDatabase? = null

        fun getDatabase(context: Context): HeroDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroDatabase::class.java,
                    "hero.db"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }


}