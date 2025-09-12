package com.example.marvel_app_project.ui.pages

/**
 * [HeroAction] is a sealed interface that store all possible UI events data.
 * It transfers them from the UI to ViewModels inside 1 structure what is matches with the MVI pattern logic.
 * See about [MVI pattern](https://www.geeksforgeeks.org/software-engineering/model-view-intent-mvi-pattern-in-reactive-programming-a-comprehensive-overview/)
 *
 * @author Zyuzin Roman
 */
sealed interface HeroAction {
    data class OnHeroImageTapped(val heroId: Int, val heroSeverId: String): HeroAction

    data class OnHeroNotificationTapped(val heroId: Int): HeroAction
    object OnBackToChooseHero: HeroAction
}