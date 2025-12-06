package com.example.marvel_app_project.di

import android.app.Application
import androidx.room.Room
import com.example.marvel_app_project.data.database.HeroDao
import com.example.marvel_app_project.data.database.HeroDatabase
import com.example.marvel_app_project.data.network.Either.EitherCallAdapterFactory
import com.example.marvel_app_project.data.network.HeroApi
import com.example.marvel_app_project.data.network.HeroApi.Companion.BASE_URL
import com.example.marvel_app_project.data.network.interceptors.AuthInterceptor.Companion.authInterceptor
import com.example.marvel_app_project.data.network.interceptors.LogInterceptor.Companion.loggingInterceptor
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

/**
 * [AppModule] is an object that handles Builders for Moshi, OkHttp, Retrofit libs.
 * It's a place where the main magic of DI happens.
 * It's hard to explain. Better see [video about Dagger Hilt DI lib](https://www.youtube.com/live/yGiCNunSVN8?si=2q-cqxnb3kFm4D50)
 *
 * [AppModule] это объект, хранящий в себе билдеры для либ Moshi, OkHttp, Retrofit.
 * Это место, где происходит DI-магия
 *
 * @author Zyuzin Roman
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /** Provides a singleton instance of [HeroDatabase] using Room.
     *
     * Передаёт [HeroDatabase] синглтон с использованием Room.
     *
     * @param app The application context used to build the database.
     * @return A singleton instance of [HeroDatabase].
     *
     * параметр app это конктекст приложения, используемый для билдинга БД.
     * возвращает синглтон типа [HeroDatabase].
     */
    @Provides
    @Singleton
    fun provideHeroDatabase(app: Application): HeroDatabase {
        return Room.databaseBuilder(
            app,
            HeroDatabase::class.java,
            "hero.db"
        ).build()
    }

    /** Provides a singleton instance of [HeroDao] from the given [HeroDatabase].
     *
     * @param database The [HeroDatabase] instance from which to obtain the DAO.
     * @return A singleton instance of [HeroDao].
     *
     * Передаёт синглтон типа [HeroDao] с использованием переданного [HeroDatabase] синглтона.
     *
     * параметр database это [HeroDatabase]-синглтон, который передаёт DAO.
     * возвращает [HeroDao]-синглтон.
     */
    @Provides
    @Singleton
    fun provideHeroDao(database: HeroDatabase): HeroDao {
        return database.heroDao()
    }

    /** Provides a singleton instance of [OkHttpClient] with logging and authentication interceptors.
     *
     * Передаёт [OkHttpClient]-синглтон с логирующим и аутентификационным интерцепторами.
     *
     * @return A singleton instance of [OkHttpClient].
     *
     * возвращает [OkHttpClient]-синглтон.
     */
    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .addNetworkInterceptor(authInterceptor)
            .build()
    }

    /** Provides a singleton instance of [Moshi] for JSON parsing.
     *
     * Передаёт [Moshi]-синглтон для парсинга JSON.
     *
     * @return A singleton instance of [Moshi].
     */
    @Provides
    @Singleton
    fun provideMoshi(): Moshi{
        return Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()
    }

    /** Provides a singleton instance of [HeroApi] using Retrofit with Moshi and Scalars converters.
     *
     * Передаёт [HeroApi]-синглтон для использовани либ Retrofit и Moshi, а также скалярных конвертеров.
     *
     * @param moshi The [Moshi] instance used for JSON conversion.
     * @param client The [OkHttpClient] instance used for network requests.
     * @return A singleton instance of [HeroApi].
     *
     * параметр moshi это [Moshi]-синглтон.
     * параметр client это [OkHttpClient]-синглтон, используемый для отправки запросов к API.
     *
      */
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

}