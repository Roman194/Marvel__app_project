package com.example.marvel_app_project.models.data.network

/**
 * [HeroDTOResponse], [HeroDTOResponseData] and [Thumbnail] it's a data classes that is used by Moshi lib
 * to convert API Response JSON string to [HeroDTO] or [ErrorResponse] (accordingly in cases of success and fail)
 * [Learn more about Moshi lib](https://github.com/square/moshi)
 *
 * @author Zyuzin Roman
 */

data class Thumbnail(
    val path: String,
    val extension: String
)
