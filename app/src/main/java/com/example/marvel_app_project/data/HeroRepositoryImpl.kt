package com.example.marvel_app_project.data

import android.annotation.SuppressLint
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.data.database.HeroDao
import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.data.network.HeroApi
import com.example.marvel_app_project.mappers.toEntity
import com.example.marvel_app_project.mappers.toStringType
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.HeroReserve
import com.example.marvel_app_project.models.data.SingleHeroReserve
import javax.inject.Inject

/**
 * This class is the implementation of [HeroRepository] interface.
 * Этот класс является реаализацией интерфейса [HeroRepository].
 * Для русских комментариев к функциям обратитесь к этому интерфейсу.
 *
 * @see HeroRepository for more info
 * @constructor is uses Dagger Hilt [Inject] to get info about initialization of [HeroApi] and [HeroDao] interfaces.
 *
 * конструктор используется для Dagger Hilt [Inject] для получения информации об интерфейсах [HeroApi] и [HeroDao].
 *
 * @author Zyuzin Roman
 */

class HeroRepositoryImpl @Inject constructor(
    private val heroDao: HeroDao,
    private val heroApi: HeroApi
): HeroRepository {

    /**
     * fun [upsertHero] is used to add new hero to DB table.
     * This function is triggered by [singleHero] fun
     * @param heroEntity is the Hero object that is going to be added
     */
    override suspend fun upsertHero(heroEntity: HeroEntity){
        heroDao.upsertHero(heroEntity)
    }

    /**
     * fun [updateHero] is used to update info about existing hero in DB table.
     * This function is triggered by [allHeroes] fun
     * @param heroEntity is the Hero object that is going to be updated
     */
    override suspend fun updateHero(heroEntity: HeroEntity){
        heroDao.updateHero(heroEntity)
    }

    /**
     * fun [allHeroes] is used to get to UI info about all heroes from the Marvel API.
     * If the request to it was failed the [HeroReserve] data will be used.
     * The function is triggered by app launches or user UI interaction
     *
     */

    override suspend fun allHeroes(): Either<HeroReserve, List<HeroEntity>> {
        val databaseHeroValues = heroDao.getAllHeroes()

        val response = heroApi.getMarvelCharacters()
        when(response){
            is Either.Fail -> {
                if(databaseHeroValues.isEmpty()){
                    SampleData.heroEntitySamples.map { heroEntity ->
                        upsertHero(heroEntity)
                    }
                }

                return Either.Fail(
                    HeroReserve(
                        errorMessage = response.value.toStringType(),
                        reserveHeroValues = heroDao.getAllHeroes()
                    )
                )
            }
            is Either.Success -> {

                response.value.data.result.map { heroMoshi ->
                    if(databaseHeroValues.find { it.serverId == heroMoshi.id } == null)
                        upsertHero(heroMoshi.toEntity())
                }

                return Either.Success(
                    heroDao.getAllHeroes()
                )
            }

        }
    }

    /**
     * fun [singleHero] is used to provide to UI the data about clicked hero. This fun is necessary to open singleHeroScreen with correct hero info.
     * The function is triggered by user UI interaction.
     * @param heroServerID is the APIs hero ID to get updated data about it.
     * @param heroID is the DB ID which is used when there is no connection with API or [heroServerID] wasn't found in API (case for heroes from [ObjectData] sample)
     */

    @SuppressLint("SuspiciousIndentation")
    override suspend fun singleHero(heroID: Int, heroServerID: String): Either<SingleHeroReserve, HeroEntity> {
        val databaseHeroValue = heroDao.getSingleHero(heroID)
        val verifiedHeroServerID = if(heroServerID != "-1") heroServerID else databaseHeroValue.serverId

            if(databaseHeroValue.description == ""){
                val response = heroApi.getSingleMarvelCharacter(id = verifiedHeroServerID.toInt())
                when(response){
                    is Either.Fail ->
                        return Either.Fail(
                            SingleHeroReserve(
                                errorMessage = response.value.toStringType(),
                                reserveHeroValue =  databaseHeroValue
                            )
                        )
                    is Either.Success -> {
                        updateHero(response.value.data.result[0].toEntity())

                        return Either.Success(
                            heroDao.getSingleHero(heroID)
                        )
                    }
                }
        }else{
            return Either.Success(
                databaseHeroValue
            )
        }
    }

    /**
     * fun [randSingleHero] isn't used in this app nowadays. It will be used to choose random hero for sending "Heroes needs you" notification.
     * Still it has fully functional realization on data layer
     */

    override suspend fun randSingleHero():HeroEntity {
        return heroDao.getRandSingleHero()
    }
}