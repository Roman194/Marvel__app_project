package com.example.marvel_app_project.ui.theme

import androidx.compose.ui.unit.dp

object Spaces {
    val singleHeroColumn = 45.dp
    val shadowElevation = 6.dp
    val chooseHeroColumn = 50.dp
    val errorColumn = 40.dp
    object singleHeroTextColumn{
        val start = 15.dp
        val bottom = 55.dp
        val end = 15.dp
    }
    object heroCardText{
        val start = 20.dp
        val bottom = 40.dp
        val end = 30.dp
    }
    object chooseHeroLazyRow{
        val horizontalPadding = 52.dp
        val horizontalArrangement = 38.dp
    }
    object chooseHeroLazyRowLandscape{
        val horizontalPadding = 325.dp
        val horizontalArrangement = 114.dp
    }
    object spacer{
        val standardWidth = 1.dp
         val smallerHeight = 5.dp
        val standardHeight = 15.dp
        val extendedHeight = 25.dp
        val theMostExtendedHeight = 40.dp
    }

}