package com.example.marvel_app_project.models.data

/**
 * [HeroReserve] it's a data class (model) that is used  to transfer data from DB or ObjectData to UI
 * in cases when response is [Either.Fail] for ChooseHeroScreen
 *
 * Дата-класс [HeroReserve] используется для передачи данных из БД или [ObjectData] на UI-слой
 * в случаях, когда ответ с сервера пришёл через [Either.Fail] в ChooseHeroScreen
 *
 * @author Zyuzin Roman
 */

data class HeroReserve(
    val errorMessage: String,
    val reserveHeroValues: List<HeroEntity>
)
