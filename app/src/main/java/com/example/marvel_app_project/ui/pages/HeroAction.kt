package com.example.marvel_app_project.ui.pages

sealed interface HeroAction {
    data class OnHeroImageTapped(val heroId: Int, val heroSeverId: String): HeroAction

    data class OnHeroNotificationTapped(val heroId: Int): HeroAction
    object OnBackToChooseHero: HeroAction
}