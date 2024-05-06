package com.example.marvel_app_project.data.network

import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.models.data.network.ErrorResponse
import com.example.marvel_app_project.models.data.network.HeroDTOResponse
import retrofit2.http.GET
import retrofit2.http.Path

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
