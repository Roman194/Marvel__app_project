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
 * [HeroDao] используется для управления взаимодействием между RoomBD и HerpRepository.
 * Функции этого интерфейса имеют идентичный функциям HeroRepository функционал
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
     *
     * функция [upsertHero] используется для добавления новго героя в БД
     * параметр hero это объект типа Hero, который будет добавлен в БД
     */
    @Upsert
    suspend fun upsertHero(hero: HeroEntity)

    /**
     * fun [updateHero] is used to update info about existing hero in DB table
     * @param hero is the Hero object that is going to be updated
     *
     * функция [updateHero] используется для обновления информации о существующем герое в БД
     * параметр hero это объект типа Hero, который будет обновлён в БД
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
     * fun [getRandSingleHero] is used to provide to UI the data about clicked hero.
     * This fun is necessary to open singleHeroScreen with correct hero info after notification message click
     *
     * функция [getRandSingleHero] используется для передачи на UI-слой информации о герое, на которого кликнул пользователь.
     * Эта функция обязательна для корректного открытия singleHeroScreen с корректной информацией о герое после клика по notification message
     */
    @Query("SELECT * FROM HeroEntity order by random() limit 1")
    suspend fun getRandSingleHero(): HeroEntity

    /**
     * fun [getAllHeroes] is used to get to UI info about all heroes from the DB table
     *
     * функция [getAllHeroes] используется для отправки на UI-слой информации обо всех героях, хранящихся в БД
     */
    @Query("SELECT * FROM HeroEntity")
    suspend fun getAllHeroes(): List<HeroEntity>
}