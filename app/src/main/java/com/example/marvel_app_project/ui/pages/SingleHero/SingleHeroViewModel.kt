package com.example.marvel_app_project.ui.pages.SingleHero

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_project.models.HeroUI
import com.example.marvel_app_project.models.toSingleUI
import com.example.marvel_app_project.network.HeroApi
import com.example.marvel_app_project.ui.pages.ChooseHero.ChooseHeroViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface SingleHeroUiState{
    data class Success(val singleHeroUIValue: HeroUI): SingleHeroUiState
    data class Error(val reserveSingleHeroUiValue: HeroUI): SingleHeroUiState
    object Loading: SingleHeroUiState
}
class SingleHeroViewModel: ViewModel() {

    private var _reserveSingleHeroUIState = MutableStateFlow( HeroUI())
    val reserveSingleHeroUIState: StateFlow<HeroUI> = _reserveSingleHeroUIState.asStateFlow()

    var singleHeroUIState: SingleHeroUiState by mutableStateOf(SingleHeroUiState.Loading)

    fun updateHeroForSingleHero(id: Int, heroName: String){

        viewModelScope.launch {
            singleHeroUIState = try{
                val responce = HeroApi.heroesRetrofitService.getSingleMarvelCharacter(id = id)
                SingleHeroUiState.Success(
                    responce.data.result[0].toSingleUI()
                )
            }catch (e: IOException){
                reserveUpdateHero(heroName = heroName)
            }catch (e: HttpException){
                reserveUpdateHero(heroName = heroName)
            }
        }
    }

    fun reserveUpdateHero(heroName: String):SingleHeroUiState{
        val chooseHeroViewModel = ChooseHeroViewModel()
        val currentHeroValues = chooseHeroViewModel.reserveHeroUIState.value
        _reserveSingleHeroUIState.value = currentHeroValues.find { it.name == heroName }?: HeroUI()

        return SingleHeroUiState.Error(_reserveSingleHeroUIState.value)
    }
}