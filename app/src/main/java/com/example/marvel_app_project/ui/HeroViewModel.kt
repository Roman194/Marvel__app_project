package com.example.marvel_app_project.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.models.HeroUI
import com.example.marvel_app_project.models.toUI
import com.example.marvel_app_project.network.HeroApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface HeroesUiState{
    data class Success(val heroUIValues: List<HeroUI>): HeroesUiState
    data class Error(val reserveHeroUiValues: List<HeroUI>): HeroesUiState
    object Loading: HeroesUiState
}
class HeroViewModel: ViewModel() {

    private var _reserveHeroUIState = MutableStateFlow(listOf( HeroUI()))
    val reserveHeroUIState: StateFlow<List<HeroUI>> = _reserveHeroUIState.asStateFlow()

    private var _singleHeroUiState = MutableStateFlow(HeroUI())
    val singleHeroUiState: StateFlow<HeroUI> = _singleHeroUiState.asStateFlow()

    var heroesUiState: HeroesUiState by mutableStateOf(HeroesUiState.Loading)

    init {
        getHeroesInfo()
    }

    fun getHeroesInfo(){
        _reserveHeroUIState.value = SampleData.heroUISamples

        viewModelScope.launch {
            heroesUiState = try{
                val response = HeroApi.heroesRetrofitService.getMarvelCharacters()
                HeroesUiState.Success(
                    response.data.result.mapIndexed{index, heroMoshi ->
                        heroMoshi.toUI(
                            toDetermineHeroNameVisiblePart(heroMoshi.name),
                            toDetermineBackgroundColor(index)
                        )
                    }
                )
            }catch (e: IOException){
                HeroesUiState.Error(_reserveHeroUIState.value)
            }catch (e: HttpException){
                HeroesUiState.Error(_reserveHeroUIState.value)
            }
        }

    }

    fun toDetermineBackgroundColor(index: Int): Color{
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

    fun toDetermineHeroNameVisiblePart(inputHeroName: String): String{
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

    fun updateHeroForSingleHero(heroName: String){
        val currentHeroValues = _reserveHeroUIState.value
        _singleHeroUiState.value = currentHeroValues.find { it.name == heroName }!!

    }

}