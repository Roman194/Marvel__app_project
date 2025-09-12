package com.example.marvel_app_project.data.network

import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.data.network.HeroApi.Companion.BASE_URL
import com.example.marvel_app_project.models.data.network.ErrorResponse
import com.example.marvel_app_project.models.data.network.HeroDTOResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * This interface is used to manage interactions between Marvel API and HeroesRepository with the usage of Retrofit lib.
 * It has [BASE_URL] as companion object and some extended URL info for every function separately.
 * About Retrofit, see [this tutorial](https://skillbox.ru/media/code/retrofit-chto-eto-za-biblioteka-i-kak-s-ney-rabotat/)
 *
 * @see ErrorResponse
 * @see HeroDTOResponse
 * @see ParseConstants
 *
 * @author Zyuzin Roman
 */
interface HeroApi{
    /**
     * fun [getMarvelCharacters] is used to get all heroes from the Marvel API (still having the limit to 10 heroes, see [ParseConstants]).
     * When the response was success returns [HeroDTOResponse], else - [ErrorResponse]
     */
    @GET("characters")
    suspend fun getMarvelCharacters(
    ): Either<ErrorResponse, HeroDTOResponse>

    /**
     * fun [getSingleMarvelCharacter] is used to get single hero from the Marvel API.
     * @property characterId provides the ID of this hero
     */

    @GET("characters/{characterId}")
    suspend fun getSingleMarvelCharacter(
        @Path("characterId") id: Int
    ): Either<ErrorResponse, HeroDTOResponse>

    companion object{
        const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    }

}
