package com.example.marvel_app_project.di

import android.app.Application
import androidx.room.Room
import com.example.marvel_app_project.data.HeroDao
import com.example.marvel_app_project.data.HeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHeroDatabase(app: Application): HeroDatabase{
        return Room.databaseBuilder(
            app,
            HeroDatabase::class.java,
            "hero.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideHeroDao(database: HeroDatabase): HeroDao{
        return database.heroDao()
    }
//    @Provides
//    @Singleton
//    fun provideHeroRepository(heroDao: HeroDao): HeroRepository {
//        return HeroRepositoryImpl(heroDao)
//    }
}