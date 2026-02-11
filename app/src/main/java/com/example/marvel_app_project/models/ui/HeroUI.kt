package com.example.marvel_app_project.models.ui

import androidx.compose.ui.graphics.Color

/**
 * [HeroUI] data class is used to transfer data from the HeroesRepository to UI (ChooseHeroScreen and SingleHeroScreen).
 * It also has its own default values to check the UI elements
 *
 * Дата-класс [HeroUI] испольузется для передачи данных из репозитория на UI-слой для обоих экранов.
 * Также имеет собственные дефолтные значения
 *
 */

data class HeroUI(
    val id: Int = 99,
    val serverId: String = "1010",
    val name: String = "hero",
    val description: String = "heroDescription",
    val image: String ="https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg",
    val backgroundColor: Color = Color(119, 3,8)
)
