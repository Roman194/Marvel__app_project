package com.example.marvel_app_project.models.data

/**
 * [HeroReserve] it's a data class (model) that is used  to transfer data from DB or ObjectData to UI
 * in cases when response is [Either.Fail] for ChooseHeroScreen
 *
 * @author Zyuzin Roman
 */

data class HeroReserve(
    val errorMessage: String,
    val reserveHeroValues: List<HeroEntity>
)
