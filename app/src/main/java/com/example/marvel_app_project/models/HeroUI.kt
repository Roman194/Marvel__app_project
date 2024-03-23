package com.example.marvel_app_project.models

import androidx.compose.ui.graphics.Color

data class HeroUI(
    val name: String = "hero",
    val description: String = "heroDescription",
    val image: String ="https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg",
    val backgroundColor: Color = Color(119, 3,8)
)
