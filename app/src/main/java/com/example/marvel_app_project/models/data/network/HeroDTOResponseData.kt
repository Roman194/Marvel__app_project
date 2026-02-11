package com.example.marvel_app_project.models.data.network

import com.squareup.moshi.Json

/**
 * [HeroDTOResponse], [HeroDTOResponseData] and [Thumbnail] it's a data classes that is used by Moshi lib
 * to convert API Response JSON string to [HeroDTO] or [ErrorResponse] (accordingly in cases of success and fail)
 * [Learn more about Moshi lib](https://github.com/square/moshi)
 *
 * @author Zyuzin Roman
 */
data class HeroDTOResponseData(
    @Json(name = "results")
    val result: List<HeroDTO>
)
