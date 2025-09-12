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

/**
 * [SingleHeroViewModel] is a class that manage SingleHeroScreen state and transfer data and events
 * between Repository and UI screen.
 * To work with data layer it uses coroutines inside function [updateHeroForSingleHero].
 *
 * @constructor uses Dagger Hilt DI [Inject] to match ViewModel entity with Repository ones.
 * @param repository is used to work with data layer.
 * @param singleHeroUIState is used to store current UI state of SingleHeroScreen.
 * @see SingleHeroScreen
 * @see HeroAction
 * @see updateHeroForSingleHero
 * @see SingleHeroUiState
 *
 * About Dagger Hilt, see [this video](https://www.youtube.com/live/yGiCNunSVN8?si=2q-cqxnb3kFm4D50)
 * About Kotlin Coroutines, see [this video](https://developer.android.com/kotlin/coroutines)
 *
 * @author Zyuzin Roman
 */

@HiltViewModel
class SingleHeroViewModel @Inject constructor(
    val repository: HeroRepository
): ViewModel() {

    var singleHeroUIState: SingleHeroUiState by mutableStateOf(SingleHeroUiState.Loading)

    /**
     * [onAction] function is used to transfer UI events from SingleHeroScreen to this ViewModel.
     * It uses [when] expression to determine which event it is and calls the corresponding function to handle it.
     * It is called when user taps on hero image on ChooseHeroScreen, on notification about hero or on back button on SingleHeroScreen
     */
    fun onAction(action: HeroAction){
        when(action){
            is HeroAction.OnHeroImageTapped ->
                updateHeroForSingleHero(
                    id = action.heroId,
                    serverId = action.heroSeverId
                )

            HeroAction.OnBackToChooseHero ->
                singleHeroUIState = SingleHeroUiState.Loading

            is HeroAction.OnHeroNotificationTapped ->
                updateHeroForSingleHero(
                    id = action.heroId,
                    serverId = "-1"
                )

        }
    }

    /**
     * [updateHeroForSingleHero] function is used to get single hero from Repository layer with the usage of coroutines.
     * It updates [singleHeroUIState] with 1 of 2 possible states: [SingleHeroUiState.Success] or [SingleHeroUiState.Error] depending on
     * the result of the request to Repository layer.
     * In case of [SingleHeroUiState.Error] it transfers hero from DB to show them on UI.
     * In case of [SingleHeroUiState.Success] it transfers hero from DB but with fresh update from Marvel API.
     * It is called from function [onAction] when user taps on hero image on ChooseHeroScreen or on notification about hero
     */
    private fun updateHeroForSingleHero(id: Int, serverId: String) {

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