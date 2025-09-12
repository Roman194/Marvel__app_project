package com.example.marvel_app_project.models.data

/**
 * [SingleHeroReserve] it's a data class (model) that is used  to transfer data from DB or ObjectData to UI
 * in cases when response is [Either.Fail] but for SingleHeroScreen
 *
 * @author Zyuzin Roman
 */
data class SingleHeroReserve(
    val errorMessage: String,
    val reserveHeroValue: HeroEntity
)
