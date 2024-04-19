package com.example.marvel_app_project.ui.pages.singlehero

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.models.data.toSingleUI
import com.example.marvel_app_project.domain.HeroRepository
import com.example.marvel_app_project.domain.SingleHeroDomainState
import kotlinx.coroutines.launch

class SingleHeroViewModel(val repository: HeroRepository): ViewModel() {

    var singleHeroUIState: SingleHeroUiState by mutableStateOf(SingleHeroUiState.Loading)

    fun updateHeroForSingleHero(id: Int, serverId: String) {

        viewModelScope.launch {

            val singleHeroDomainState = repository.singleHero(heroID = id, heroServerID = serverId)
            singleHeroUIState =
                when (singleHeroDomainState) {
                    is SingleHeroDomainState.Error -> SingleHeroUiState.Error(
                        errorMessage = singleHeroDomainState.errorMessage,
                        reserveSingleHeroUiValue = singleHeroDomainState.singleHeroValue.toSingleUI()
                    )
                    is SingleHeroDomainState.Success -> SingleHeroUiState.Success(
                        singleHeroUIValue = singleHeroDomainState.singleHeroValue.toSingleUI()
                    )
                    is SingleHeroDomainState.Loading -> SingleHeroUiState.Loading
            }
        }
    }
}