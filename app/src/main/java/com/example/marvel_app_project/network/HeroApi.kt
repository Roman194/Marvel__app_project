package com.example.marvel_app_project.network

import com.example.marvel_app_project.models.data.network.ErrorResponse
import com.example.marvel_app_project.models.data.network.HeroDTOResponse
import com.example.marvel_app_project.network.Either.Either
import retrofit2.http.GET
import retrofit2.http.Path

//private const val BASE_URL = "http://gateway.marvel.com/v1/public/"

//val moshi = Moshi.Builder()
//    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
//    .build()
//
//private val retrofit = Retrofit.Builder()
//    .client(client)
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .addConverterFactory(
//        MoshiConverterFactory.create(moshi))
//    .addCallAdapterFactory(EitherCallAdapterFactory())
//    .baseUrl(BASE_URL)
//    .build()

interface HeroApi{
    @GET("characters")
    suspend fun getMarvelCharacters(
    ): Either<ErrorResponse, HeroDTOResponse>

    @GET("characters/{characterId}")
    suspend fun getSingleMarvelCharacter(
        @Path("characterId") id: Int
    ): Either<ErrorResponse, HeroDTOResponse>

    companion object{
        const val BASE_URL = "http://gateway.marvel.com/v1/public/"
    }

}

//object HeroApi{
//    val heroesRetrofitService: HeroApiService by lazy {
//        retrofit.create(HeroApiService::class.java)
//    }
//}