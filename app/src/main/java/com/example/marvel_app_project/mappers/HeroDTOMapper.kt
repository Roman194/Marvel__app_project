package com.example.marvel_app_project.mappers

import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.network.HeroDTO

/**
 * This fun converts [HeroDTO] to [HeroEntity] data class.
 *
 * Данная функция конвертирует [HeroDTO] в [HeroEntity] дата-класс.
 *
 * @see HeroDTO
 * @see HeroEntity
 * @author Zyuzin Roman
 */
fun HeroDTO.toEntity() =
    HeroEntity(
        serverId = id,
        name = name,
        description = description,
        image = thumbnail.path + "." +  thumbnail.extension
    )