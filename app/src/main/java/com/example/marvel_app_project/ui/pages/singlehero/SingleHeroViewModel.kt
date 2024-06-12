package com.example.marvel_app_project.ui.pages.singlehero

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.data.HeroRepository
import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.mappers.toSingleUI
import com.example.marvel_app_project.ui.pages.HeroAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleHeroViewModel @Inject constructor(
    val repository: HeroRepository
): ViewModel() {

    var singleHeroUIState: SingleHeroUiState by mutableStateOf(SingleHeroUiState.Loading)

    fun onAction(action: HeroAction){
        when(action){
            is HeroAction.OnHeroImageTapped ->
                updateHeroForSingleHero(
                    id = action.heroId,
                    serverId = action.heroSeverId
                )

            HeroAction.OnBackToChooseHero ->
                singleHeroUIState = SingleHeroUiState.Loading

        }
    }

    fun updateHeroForSingleHero(id: Int, serverId: String) {

        viewModelScope.launch {

            val responseFromRepo = repository.singleHero(heroID = id, heroServerID = serverId)
            singleHeroUIState =
                when (responseFromRepo) {
                    is Either.Fail -> SingleHeroUiState.Error(
                        errorMessage = responseFromRepo.value.errorMessage,
                        reserveSingleHeroUiValue = responseFromRepo.value.reserveHeroValue.toSingleUI()
                    )
                    is Either.Success -> SingleHeroUiState.Success(
                        singleHeroUIValue = responseFromRepo.value.toSingleUI()
                    )
                }
        }
    }
}