package com.example.marvel_app_project.data

import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.HeroReserve
import com.example.marvel_app_project.models.data.SingleHeroReserve

interface HeroRepository {

    suspend fun upsertHero(heroEntity: HeroEntity)

    suspend fun updateHero(heroEntity: HeroEntity)

    suspend fun allHeroes(): Either<HeroReserve, List<HeroEntity>>

    suspend fun randSingleHero(): HeroEntity

    suspend fun singleHero(heroID: Int, heroServerID: String): Either<SingleHeroReserve, HeroEntity>
}