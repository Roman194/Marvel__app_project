package com.example.marvel_app_project.network

import com.example.marvel_app_project.BuildConfig
import com.example.marvel_app_project.models.MoshiResponse
import com.example.marvel_app_project.models.MoshiResponseData
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


private const val BASE_URL = "http://gateway.marvel.com/v1/public/"


class ParceConstants{
    companion object{
        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        const val limit = "10"

        const val API_KEY = BuildConfig.API_KEY
        const val PRIVATE_API_KEY = BuildConfig.PRIVATE_API_KEY

        fun hash():String{
            val inputHashString = "$ts$PRIVATE_API_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(inputHashString.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}

val authInterceptor = Interceptor{chain ->
    val originalRequest = chain.request()

    val newHttpUrl = originalRequest.url.newBuilder()
        .addQueryParameter("apikey", ParceConstants.API_KEY)
        .addQueryParameter("ts", ParceConstants.ts)
        .addQueryParameter("hash", ParceConstants.hash())
        .addQueryParameter("limit", ParceConstants.limit)
        .build()

    val newRequest = originalRequest.newBuilder()
        .url(newHttpUrl)
        .build()

    chain.proceed(newRequest)
}

val loggingInterceptor = HttpLoggingInterceptor()
    .apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

val client = OkHttpClient.Builder()
    .addNetworkInterceptor(loggingInterceptor)
    .addNetworkInterceptor(authInterceptor)
    .build()


val moshi = Moshi.Builder()
    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(
        MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HeroApiService{
    @GET("characters")
    suspend fun getMarvelCharacters(
    ):MoshiResponse

    @GET("characters/{characterId}")
    suspend fun getSingleMarvelCharacter(
        @Path("characterId") id: Int
    ):MoshiResponse

}

object HeroApi{
    val heroesRetrofitService: HeroApiService by lazy {
        retrofit.create(HeroApiService::class.java)
    }
}