package com.example.marvel_app_project.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.models.data.HeroEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [HeroEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao

    private class HeroDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val heroDao = database.heroDao()
                    val heroSamples = SampleData.heroEntitySamples
                    heroSamples.forEach { heroEntity ->
                        heroDao.upsertHero(heroEntity)
                    }

                }
            }
        }
    }
    companion object{
        @Volatile
        private var INSTANCE: HeroDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): HeroDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroDatabase::class.java,
                    "hero_attempt_4.db"
                )
                    //.addCallback(HeroDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }

        }
    }


}