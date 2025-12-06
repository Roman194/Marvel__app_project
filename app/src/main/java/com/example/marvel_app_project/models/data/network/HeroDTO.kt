package com.example.marvel_app_project.models.data.network

/**
 * [HeroDTO] it's a data class (model) that is used to transfer response data from API
 * to Repository in cases when response is [Either.Success].
 * Later it will be converted in Repository to [HeroEntity]
 *
 * Дата-класс [HeroDTO] используется для передачи ответа сервера с API ([Either.Success]).
 * В дальнейшем его данные буду конвертированы в репозитории в [HeroEntity]
 *
 * @author Zyuzin Roman
 */

data class HeroDTO(
    val id: String,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)
