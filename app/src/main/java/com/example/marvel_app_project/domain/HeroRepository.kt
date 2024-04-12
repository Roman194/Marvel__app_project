package com.example.marvel_app_project.domain

import com.example.marvel_app_project.data.HeroDao
import com.example.marvel_app_project.data.HeroEntity
import kotlinx.coroutines.flow.Flow

class HeroRepository(private val heroDao: HeroDao) {

    suspend fun allHeroes(): Flow<List<HeroEntity>> {
        return heroDao.getAllHeroes()
    }
    suspend fun singleHero(heroID: Int): Flow<HeroEntity> {
        return heroDao.getSingleHero(heroID)
    }
    suspend fun upsertHero(heroEntity: HeroEntity){
        heroDao.upsertHero(heroEntity)
    }
}