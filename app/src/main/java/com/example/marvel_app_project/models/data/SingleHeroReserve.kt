package com.example.marvel_app_project.models.data

/**
 * [SingleHeroReserve] it's a data class (model) that is used  to transfer data from DB or ObjectData to UI
 * in cases when response is [Either.Fail] but for SingleHeroScreen
 *
 * Дата-класс [SingleHeroReserve] используется для передачи данных из БД или [ObjectData] на UI-слой
 * в случаях, когда ответ с сервера пришёл через [Either.Fail] в SingleHeroScreen
 *
 * @author Zyuzin Roman
 */
data class SingleHeroReserve(
    val errorMessage: String,
    val reserveHeroValue: HeroEntity
)
