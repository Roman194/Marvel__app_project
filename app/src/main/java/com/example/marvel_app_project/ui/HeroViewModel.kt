package com.example.marvel_app_project.ui

import androidx.lifecycle.ViewModel
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.models.HeroUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HeroViewModel: ViewModel() {

    private var _heroUIState = MutableStateFlow(listOf( HeroUI()))
    val heroUIState: StateFlow<List<HeroUI>> = _heroUIState.asStateFlow()

    private var _singleHeroUiState = MutableStateFlow(HeroUI())
    val singleHeroUiState: StateFlow<HeroUI> = _singleHeroUiState.asStateFlow()

    init {
        getHeroesInfo()
    }

    fun getHeroesInfo(){
        _heroUIState.value = SampleData.heroUISamples
    }

    fun updateHeroForSingleHero(heroName: String){
        val currentHeroValues = _heroUIState.value
        _singleHeroUiState.value = currentHeroValues.find { it.name == heroName }!!

    }

}