package com.example.marvel_app_project.ui.pages.singlehero

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marvel_app_project.data.toSingleUI
import com.example.marvel_app_project.data.toUI
import com.example.marvel_app_project.domain.HeroRepository
import com.example.marvel_app_project.models.UiLayer.HeroUI
import com.example.marvel_app_project.models.DataLayer.toSingleUI
import com.example.marvel_app_project.models.DataLayer.toStringType
import com.example.marvel_app_project.network.Either.Either
import com.example.marvel_app_project.network.HeroApi
import com.example.marvel_app_project.ui.pages.choosehero.ChooseHeroViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SingleHeroViewModel(val repository: HeroRepository): ViewModel() {

    private var _reserveSingleHeroUIState = MutableStateFlow(HeroUI())

    var singleHeroUIState: SingleHeroUiState by mutableStateOf(SingleHeroUiState.Loading)

    fun updateHeroForSingleHero(id: Int, heroName: String) {

        viewModelScope.launch {
            val response = HeroApi.heroesRetrofitService.getSingleMarvelCharacter(id = id)
            singleHeroUIState =
                when (response) {
                    is Either.Fail -> SingleHeroUiState.Error(
                        errorMessage = response.value.toStringType(),
                        reserveSingleHeroUiValue = repository.singleHero(heroID = id).toSingleUI()
                        //reserveUpdateHero(heroName = heroName)
                    )
                    is Either.Success -> SingleHeroUiState.Success(
                        singleHeroUIValue = response.value.data.result[0].toSingleUI()
                    )
            }
        }
    }
    private fun reserveUpdateHero(heroName: String): HeroUI {
        val chooseHeroViewModel = ChooseHeroViewModel(repository)
        val currentHeroValues = chooseHeroViewModel.reserveHeroUIState.value
        _reserveSingleHeroUIState.value = currentHeroValues.find { it.name == heroName }?: HeroUI()

        return _reserveSingleHeroUIState.value
    }
}