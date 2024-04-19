package com.example.marvel_app_project.domain

import com.example.marvel_app_project.models.data.HeroEntity

sealed interface SingleHeroDomainState {
    data class Success(val singleHeroValue: HeroEntity): SingleHeroDomainState
    data class Error(val errorMessage:String, val singleHeroValue: HeroEntity): SingleHeroDomainState
    object Loading: SingleHeroDomainState
}