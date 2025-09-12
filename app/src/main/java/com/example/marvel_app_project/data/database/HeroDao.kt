package com.example.marvel_app_project.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.marvel_app_project.models.data.HeroEntity

/**
 * [HeroDao] is used to manage interaction between RoomDB and HeroRepository.
 * The functions of this interface have the same functional as the functions of Hero Repository.
 *
 * @see HeroEntity
 * @see HeroRepository
 * @author Zyuzin Roman
 */
@Dao
interface HeroDao {

    /**
     * fun [upsertHero] is used to add new hero to DB table
     * @param hero is the Hero object that is going to be added
     */
    @Upsert
    suspend fun upsertHero(hero: HeroEntity)

    /**
     * fun [updateHero] is used to update info about existing hero in DB table
     * @param hero is the Hero object that is going to be updated
     */
    @Update
    suspend fun updateHero(hero: HeroEntity)

    /**
     * fun [getSingleHero] is used to provide to UI the data about clicked hero. This fun is necessary to open singleHeroScreen with correct hero info
     * @param heroID is the DB ID which is used get updated data about it
     */
    @Query("SELECT * FROM HeroEntity WHERE HeroEntity.id == :heroID")
    suspend fun getSingleHero(heroID: Int): HeroEntity

    /**
     * fun [getRandSingleHero] is used to provide to UI the data about clicked hero. This fun is necessary to open singleHeroScreen with correct hero info after notification message click
     */
    @Query("SELECT * FROM HeroEntity order by random() limit 1")
    suspend fun getRandSingleHero(): HeroEntity

    /**
     * fun [getAllHeroes] is used to get to UI info about all heroes from the DB table
     *
     */
    @Query("SELECT * FROM HeroEntity")
    suspend fun getAllHeroes(): List<HeroEntity>
}