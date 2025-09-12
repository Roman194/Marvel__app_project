package com.example.marvel_app_project.ui.pages.choosehero

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.data.HeroRepository
import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.mappers.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [ChooseHeroViewModel] is a class that manage ChooseHeroScreen state and transfer data and events
 * between Repository and UI screen.
 * To work with data layer it uses coroutines inside function [getHeroesInfo].
 *
 * @constructor uses Dagger Hilt DI [Inject] to match ViewModel entity with Repository ones.
 *
 * @param repository is used to work with data layer.
 * @param heroesUiState is used to store current UI state of ChooseHeroScreen.
 *
 * @see ChooseHeroScreen
 *
 * About Dagger Hilt, see [this video](https://www.youtube.com/live/yGiCNunSVN8?si=2q-cqxnb3kFm4D50)
 * About Kotlin Coroutines, see [this video](https://developer.android.com/kotlin/coroutines)
 *
 * @author Zyuzin Roman
 */

@HiltViewModel
class ChooseHeroViewModel @Inject constructor(
    val repository: HeroRepository
): ViewModel() {

    var heroesUiState: ChooseHeroesUiState by mutableStateOf(ChooseHeroesUiState.Loading)

    init {
        getHeroesInfo()
    }

    /**
     * [getHeroesInfo] function is used to get all heroes from Repository layer with the usage of coroutines.
     * It updates [heroesUiState] with 1 of 2 possible states: [ChooseHeroesUiState.Success] or [ChooseHeroesUiState.Error]
     * depending on the result of the request to Repository layer.
     * In case of [ChooseHeroesUiState.Error] it transfers heroes from DB to show them on UI.
     * In case of [ChooseHeroesUiState.Success] it transfers all heroes from DB but with fresh update from Marvel API.
     * It also determines background color and visible part of hero name for each hero.
     * See functions [toDetermineBackgroundColor] and [toDetermineHeroNameVisiblePart].
     * [getHeroesInfo] is called during initialization of this app as a manager for ChooseHeroScreen state (ChooseHeroScreen is the started screen of this app).
     * @see ChooseHeroesUiState
     * @see toDetermineBackgroundColor
     * @see toDetermineHeroNameVisiblePart
     * @author Zyuzin Roman
     */

    fun getHeroesInfo() {

        viewModelScope.launch {
            val responseFromRepo = repository.allHeroes()

            heroesUiState =
                when (responseFromRepo) {
                    is Either.Fail -> ChooseHeroesUiState.Error(
                        errorMessage = responseFromRepo.value.errorMessage,
                        reserveHeroUiValues = responseFromRepo.value.reserveHeroValues.mapIndexed { index, heroEntity ->
                            heroEntity.toUI(
                                toDetermineHeroNameVisiblePart(heroEntity.name),
                                toDetermineBackgroundColor(index)
                            )
                        }
                    )
                    is Either.Success -> ChooseHeroesUiState.Success(
                        heroUIValues = responseFromRepo.value.mapIndexed { index, heroEntity ->
                            heroEntity.toUI(
                                toDetermineHeroNameVisiblePart(heroEntity.name),
                                toDetermineBackgroundColor(index)
                            )
                        }
                    )
                }
        }
    }

    private fun toDetermineBackgroundColor(index: Int): Color{
        val determinedColor =
            when(index % 7){
                0 -> Color(119, 3,8)
                1 -> Color(152, 21,26)
                2 -> Color(62, 79,181)
                3 -> Color(76, 175, 80)
                4 -> Color(7, 122,82)
                5 -> Color(12, 131,186)
                else -> Color(108, 16,197)
        }
        return determinedColor
    }

    private fun toDetermineHeroNameVisiblePart(inputHeroName: String): String{
        if(inputHeroName.length > 15){
            var outputHeroName = ""
            val heroNameArray = inputHeroName.split(" ")

            heroNameArray.forEach { namePart ->
                if((outputHeroName + namePart).length > 15){
                    return "$outputHeroName..."
                }
                outputHeroName += namePart

            }
        }
        return inputHeroName
    }
}

