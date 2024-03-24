package com.example.marvel_app_project.network

import com.example.marvel_app_project.BuildConfig
import com.example.marvel_app_project.models.MoshiResponse
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
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

val moshi = Moshi.Builder()
    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(
        MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HeroApiService{
    @GET("characters")
    suspend fun getMarvelCharacters(
        @Query("apikey") apiKey: String = ParceConstants.API_KEY,
        @Query("ts") ts: String = ParceConstants.ts,
        @Query("hash") hash: String = ParceConstants.hash(),
        @Query("limit") limit: String = ParceConstants.limit
    ):MoshiResponse

}

object HeroApi{
    val heroesRetrofitService: HeroApiService by lazy {
        retrofit.create(HeroApiService::class.java)
    }
}