package com.example.marvel_app_project.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.models.HeroUI
import com.example.marvel_app_project.network.HeroApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface HeroesUiState{
    data class Success(val listResult: String): HeroesUiState
    object Error: HeroesUiState
    object Loading: HeroesUiState
}
class HeroViewModel: ViewModel() {

    private var _heroUIState = MutableStateFlow(listOf( HeroUI()))
    val heroUIState: StateFlow<List<HeroUI>> = _heroUIState.asStateFlow()

    private var _singleHeroUiState = MutableStateFlow(HeroUI())
    val singleHeroUiState: StateFlow<HeroUI> = _singleHeroUiState.asStateFlow()

    var heroesUiState: HeroesUiState by mutableStateOf(HeroesUiState.Loading)

    init {
        getHeroesInfo()
    }

    fun getHeroesInfo(){
        _heroUIState.value = SampleData.heroUISamples

        viewModelScope.launch {
            heroesUiState = try{
                val listResult = HeroApi.heroesRetrofitService.getMarvelCharacters()
                HeroesUiState.Success(listResult)
            }catch (e: IOException){
                HeroesUiState.Error
            }catch (e: HttpException){
                HeroesUiState.Error
            }
        }

    }

    fun updateHeroForSingleHero(heroName: String){
        val currentHeroValues = _heroUIState.value
        _singleHeroUiState.value = currentHeroValues.find { it.name == heroName }!!

    }

}