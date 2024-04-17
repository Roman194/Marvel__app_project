package com.example.marvel_app_project.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {

    @Upsert
    suspend fun upsertHero(hero: HeroEntity)

    @Query("SELECT * FROM HeroEntity WHERE HeroEntity.id == :heroID")
    suspend fun getSingleHero(heroID: Int): HeroEntity

    @Query("SELECT * FROM HeroEntity")
    suspend fun getAllHeroes(): List<HeroEntity>
}