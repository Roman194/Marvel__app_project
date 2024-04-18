package com.example.marvel_app_project.ui.pages.singlehero

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.data.toSingleUI
import com.example.marvel_app_project.domain.HeroRepository
import com.example.marvel_app_project.domain.SingleHeroDomainState
import com.example.marvel_app_project.models.DataLayer.toSingleUI
import com.example.marvel_app_project.models.DataLayer.toStringType
import com.example.marvel_app_project.network.Either.Either
import kotlinx.coroutines.launch

class SingleHeroViewModel(val repository: HeroRepository): ViewModel() {

    //private var _reserveSingleHeroUIState = MutableStateFlow(HeroUI())

    var singleHeroUIState: SingleHeroUiState by mutableStateOf(SingleHeroUiState.Loading)

    fun updateHeroForSingleHero(id: Int, serverId: String) {

        viewModelScope.launch {
            val singleHeroDomainState = repository.getSingleHero(heroID = id, heroServerID = serverId)//HeroApi.heroesRetrofitService.getSingleMarvelCharacter(id = id)
            singleHeroUIState =
                when (singleHeroDomainState) {
                    is SingleHeroDomainState.Error -> SingleHeroUiState.Error(
                        errorMessage = singleHeroDomainState.errorMessage,
                        reserveSingleHeroUiValue = singleHeroDomainState.singleHeroValue.toSingleUI()
                        //reserveUpdateHero(heroName = heroName)
                    )
                    is SingleHeroDomainState.Success -> SingleHeroUiState.Success(
                        singleHeroUIValue = singleHeroDomainState.singleHeroValue.toSingleUI()
                    )
                    is SingleHeroDomainState.Loading -> SingleHeroUiState.Loading
            }
        }
    }
//    private fun reserveUpdateHero(heroName: String): HeroUI {
//        val chooseHeroViewModel = ChooseHeroViewModel(repository)
//        val currentHeroValues = chooseHeroViewModel.reserveHeroUIState.value
//        _reserveSingleHeroUIState.value = currentHeroValues.find { it.name == heroName }?: HeroUI()
//
//        return _reserveSingleHeroUIState.value
//    }
}