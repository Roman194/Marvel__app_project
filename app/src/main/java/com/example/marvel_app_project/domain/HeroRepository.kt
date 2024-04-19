package com.example.marvel_app_project.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.data.HeroDao
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.network.toEntity
import com.example.marvel_app_project.models.data.network.toStringType
import com.example.marvel_app_project.network.HeroApi
import com.example.marvel_app_project.network.Either.Either

class HeroRepository(private val heroDao: HeroDao) {

    private var heroesDomainState: ChooseHeroesDomainState by mutableStateOf(ChooseHeroesDomainState.Loading)
    private var singleHeroDomainState: SingleHeroDomainState by mutableStateOf(SingleHeroDomainState.Loading)

    suspend fun upsertHero(heroEntity: HeroEntity){
        heroDao.upsertHero(heroEntity)
    }

    suspend fun updateHero(heroEntity: HeroEntity){
        heroDao.updateHero(heroEntity)
    }

    suspend fun allHeroes(): ChooseHeroesDomainState{
        val databaseHeroValues = heroDao.getAllHeroes()

        val response = HeroApi.heroesRetrofitService.getMarvelCharacters()
        heroesDomainState = when(response){
            is Either.Fail -> {
                if(databaseHeroValues.isEmpty()){
                    SampleData.heroEntitySamples.map { heroEntity ->
                        upsertHero(heroEntity)
                    }
                }

                ChooseHeroesDomainState.Error(
                    errorMessage = response.value.toStringType(),
                    heroValues = heroDao.getAllHeroes()
                )
            }
            is Either.Success -> {

                response.value.data.result.map { heroMoshi ->
                    if(databaseHeroValues.find { it.serverId == heroMoshi.id } == null)
                        upsertHero(heroMoshi.toEntity())
                }
                ChooseHeroesDomainState.Success(heroValues = heroDao.getAllHeroes())
            }

        }
        return heroesDomainState
    }

    suspend fun singleHero(heroID: Int, heroServerID: String): SingleHeroDomainState{
        val databaseHeroValue = heroDao.getSingleHero(heroID)
        singleHeroDomainState =
            if(databaseHeroValue.description == ""){
                val response = HeroApi.heroesRetrofitService.getSingleMarvelCharacter(id = heroServerID.toInt())
                when(response){
                    is Either.Fail -> SingleHeroDomainState.Error(
                        errorMessage = response.value.toStringType(),
                        singleHeroValue =  databaseHeroValue
                        )
                    is Either.Success -> {
                        updateHero(response.value.data.result[0].toEntity())
                        SingleHeroDomainState.Success(
                            singleHeroValue = heroDao.getSingleHero(heroID)
                        )
                    }
                }
        }else{
            SingleHeroDomainState.Success(
                singleHeroValue = databaseHeroValue
            )
        }
        return singleHeroDomainState
    }
}