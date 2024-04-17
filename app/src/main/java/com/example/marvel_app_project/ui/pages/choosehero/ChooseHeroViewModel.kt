package com.example.marvel_app_project.ui.pages.choosehero

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.data.toUI
import com.example.marvel_app_project.domain.HeroRepository
import com.example.marvel_app_project.models.UiLayer.HeroUI
import com.example.marvel_app_project.models.DataLayer.toStringType
import com.example.marvel_app_project.models.DataLayer.toUI
import com.example.marvel_app_project.network.Either.Either
import com.example.marvel_app_project.network.HeroApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class ChooseHeroViewModel(val repository: HeroRepository): ViewModel() {

    private var _reserveHeroUIState = MutableStateFlow(listOf( HeroUI()))
    val reserveHeroUIState: StateFlow<List<HeroUI>> = _reserveHeroUIState.asStateFlow()

    var heroesUiState: ChooseHeroesUiState by mutableStateOf(ChooseHeroesUiState.Loading)

    init {
        getHeroesInfo()
    }

    fun getHeroesInfo() {
        //_reserveHeroUIState.value = SampleData.heroUISamples

        viewModelScope.launch {

            val response = HeroApi.heroesRetrofitService.getMarvelCharacters()

            heroesUiState =
                when (response) {
                    is Either.Fail -> ChooseHeroesUiState.Error(
                        errorMessage = response.value.toStringType(),
                        reserveHeroUiValues = repository.allHeroes().mapIndexed { index, heroEntity ->
                            heroEntity.toUI(
                                toDetermineBackgroundColor(index)
                            )
                        } //_reserveHeroUIState.value
                    )
                    is Either.Success -> ChooseHeroesUiState.Success(
                        heroUIValues = response.value.data.result.mapIndexed { index, heroMoshi ->
                            heroMoshi.toUI(
                                toDetermineHeroNameVisiblePart(heroMoshi.name),
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

