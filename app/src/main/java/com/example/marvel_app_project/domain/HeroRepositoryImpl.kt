package com.example.marvel_app_project.domain

import android.annotation.SuppressLint
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.data.HeroDao
import com.example.marvel_app_project.mappers.toEntity
import com.example.marvel_app_project.mappers.toStringType
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.HeroReserve
import com.example.marvel_app_project.models.data.SingleHeroReserve
import com.example.marvel_app_project.network.Either.Either
import com.example.marvel_app_project.network.HeroApi
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(
    private val heroDao: HeroDao
): HeroRepository {

    override suspend fun upsertHero(heroEntity: HeroEntity){
        heroDao.upsertHero(heroEntity)
    }

    override suspend fun updateHero(heroEntity: HeroEntity){
        heroDao.updateHero(heroEntity)
    }

    override suspend fun allHeroes(): Either<HeroReserve, List<HeroEntity>>{
        val databaseHeroValues = heroDao.getAllHeroes()

        val response = HeroApi.heroesRetrofitService.getMarvelCharacters()
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

    @SuppressLint("SuspiciousIndentation")
    override suspend fun singleHero(heroID: Int, heroServerID: String): Either<SingleHeroReserve, HeroEntity>{
        val databaseHeroValue = heroDao.getSingleHero(heroID)
            if(databaseHeroValue.description == ""){
                val response = HeroApi.heroesRetrofitService.getSingleMarvelCharacter(id = heroServerID.toInt())
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
}