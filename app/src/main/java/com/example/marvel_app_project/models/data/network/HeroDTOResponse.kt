package com.example.marvel_app_project.models.data.network

/**
 * [HeroDTOResponse], [HeroDTOResponseData] and [Thumbnail] it's a data classes that is used by Moshi lib
 * to convert API Response JSON string to [HeroDTO] or [ErrorResponse] (accordingly in cases of success and fail)
 * [Learn more about Moshi lib](https://github.com/square/moshi)
 *
 * Дата-классы [HeroDTOResponse], [HeroDTOResponseData] and [Thumbnail] используются либой Moshi для
 * конвертации JSON-строки ответа сервера к дата-классам [HeroDTO] or [ErrorResponse] (в зависимости от успешности выполнения запроса)
 * @author Zyuzin Roman
 */

data class HeroDTOResponse(
    val data: HeroDTOResponseData
)
