package com.example.marvel_app_project.di

import android.app.Application
import androidx.room.Room
import com.example.marvel_app_project.data.HeroDao
import com.example.marvel_app_project.data.HeroDatabase
import com.example.marvel_app_project.network.Either.EitherCallAdapterFactory
import com.example.marvel_app_project.network.HeroApi
import com.example.marvel_app_project.network.HeroApi.Companion.BASE_URL
import com.example.marvel_app_project.network.authInterceptor
import com.example.marvel_app_project.network.loggingInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
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

    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .addNetworkInterceptor(authInterceptor)
            .build()
    }
    @Provides
    @Singleton
    fun provideMoshi(): Moshi{
        return Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideHeroApi(moshi: Moshi, client: OkHttpClient): HeroApi {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(EitherCallAdapterFactory())
            .baseUrl(BASE_URL)
            .build()
            .create(HeroApi::class.java)
    }
//    @Provides
//    @Singleton
//    fun provideHeroRepository(heroDao: HeroDao): HeroRepository {
//        return HeroRepositoryImpl(heroDao)
//    }
}