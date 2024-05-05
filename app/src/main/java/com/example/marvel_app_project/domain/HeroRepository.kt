package com.example.marvel_app_project.domain

import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.HeroReserve
import com.example.marvel_app_project.models.data.SingleHeroReserve
import com.example.marvel_app_project.network.Either.Either

interface HeroRepository {

    suspend fun upsertHero(heroEntity: HeroEntity)

    suspend fun updateHero(heroEntity: HeroEntity)

    suspend fun allHeroes(): Either<HeroReserve, List<HeroEntity>>

    suspend fun singleHero(heroID: Int, heroServerID: String): Either<SingleHeroReserve, HeroEntity>
}