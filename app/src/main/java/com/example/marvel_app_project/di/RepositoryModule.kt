package com.example.marvel_app_project.di

import com.example.marvel_app_project.data.HeroRepository
import com.example.marvel_app_project.data.HeroRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * [RepositoryModule] is a Dagger Hilt DI module.
 * In this file binding with HeroRepository happens (with the usage of [bindsHeroRepository] fun)
 * See [video about Dagger Hilt DI lib](https://www.youtube.com/live/yGiCNunSVN8?si=2q-cqxnb3kFm4D50)
 *
 * @see AppModule
 * @author Zyuzin Roman
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /** Binds the [HeroRepositoryImpl] implementation to the [HeroRepository] interface.
     *
     * This function tells Dagger Hilt to use [HeroRepositoryImpl] whenever [HeroRepository] is requested.
     * The binding is scoped as a singleton, meaning the same instance will be provided throughout the app's lifecycle.
     *
     * @param heroRepositoryImpl The implementation of [HeroRepository] to be used.
     * @return The bound [HeroRepository] instance.
     */
    @Binds
    @Singleton
    abstract fun bindsHeroRepository(heroRepositoryImpl: HeroRepositoryImpl): HeroRepository
}