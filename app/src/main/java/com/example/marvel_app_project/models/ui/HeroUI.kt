package com.example.marvel_app_project.models.ui

import androidx.compose.ui.graphics.Color

/**
 * [HeroUI] data class is used to transfer data from the HeroesRepository to UI (ChooseHeroScreen and SingleHeroScreen).
 * It also has its own default values to check the UI elements
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
