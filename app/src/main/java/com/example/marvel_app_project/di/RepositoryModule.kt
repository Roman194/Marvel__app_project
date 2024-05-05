package com.example.marvel_app_project.di

import com.example.marvel_app_project.domain.HeroRepository
import com.example.marvel_app_project.domain.HeroRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsHeroRepository(heroRepositoryImpl: HeroRepositoryImpl): HeroRepository
}