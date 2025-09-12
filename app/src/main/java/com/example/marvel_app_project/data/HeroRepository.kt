package com.example.marvel_app_project.data

import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.HeroReserve
import com.example.marvel_app_project.models.data.SingleHeroReserve

/**
 * It's the interface that is used to communicate between UI ViewModels and different data layer services (Network / DataBase).
 * It has it's implementation as [HeroRepositoryImpl].
 *
 * @see HeroEntity
 * @see HeroReserve
 * @see SingleHeroReserve
 * @see Either
 * @author Zyuzin Roman
 *
 */
interface HeroRepository {

    /**
     * fun [upsertHero] is used to add new hero to DB table.
     * This function is triggered by [singleHero] fun
     * @property heroEntity is the Hero object that is going to be added
     */

    suspend fun upsertHero(heroEntity: HeroEntity)

    /**
     * fun [updateHero] is used to update info about existing hero in DB table.
     * This function is triggered by [allHeroes] fun
     * @property heroEntity is the Hero object that is going to be updated
     */

    suspend fun updateHero(heroEntity: HeroEntity)

    /**
     * fun [allHeroes] is used to get to UI info about all heroes from the Marvel API.
     * If the request to it was failed the [HeroReserve] data will be used.
     * The function is triggered by app launches or user UI interaction
     *
     */

    suspend fun allHeroes(): Either<HeroReserve, List<HeroEntity>>

    /**
     * fun [randSingleHero] isn't used in this app nowadays. It will be used to choose random hero for sending "Heroes needs you" notification.
     * Still it has fully functional realization on data layer
     */

    suspend fun randSingleHero(): HeroEntity

    /**
     * fun [singleHero] is used to provide to UI the data about clicked hero. This fun is necessary to open singleHeroScreen with correct hero info.
     * The function is triggered by user UI interaction.
     * @property heroServerID is the APIs hero ID to get updated data about it.
     * @property heroID is the DB ID which is used when there is no connection with API or [heroServerID] wasn't found in API (case for heroes from [ObjectData] sample)
     */

    suspend fun singleHero(heroID: Int, heroServerID: String): Either<SingleHeroReserve, HeroEntity>
}