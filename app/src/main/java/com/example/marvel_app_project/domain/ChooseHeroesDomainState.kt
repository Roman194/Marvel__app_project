package com.example.marvel_app_project.domain

import com.example.marvel_app_project.data.HeroEntity

sealed interface ChooseHeroesDomainState {
    data class Success(val heroValues: List<HeroEntity>):ChooseHeroesDomainState
    data class Error(val errorMessage: String, val heroValues: List<HeroEntity>):ChooseHeroesDomainState
    object Loading: ChooseHeroesDomainState
}