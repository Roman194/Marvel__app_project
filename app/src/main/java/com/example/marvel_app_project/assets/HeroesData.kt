package com.example.marvel_app_project.assets

import androidx.compose.ui.graphics.Color
import com.example.marvel_app_project.data.HeroEntity
import com.example.marvel_app_project.models.UiLayer.HeroUI

object SampleData{
    val heroUISamples = listOf(
        HeroUI(
            94,
            "Deadpool",
            "Please don’t make the super suit green...or animated!",
            "https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg",
            Color(119, 3,8)
        ),
        HeroUI(
            95,
            "Iron Man",
            "I AM IRON MAN",
            "https://cdn1.ozone.ru/s3/multimedia-q/6630703910.jpg",
            Color(152, 21,26)
        ),
        HeroUI(
            96,
            "Captain America",
            "I really miss the days when the weirdest thing science ever created was me",
            "https://proprikol.ru/wp-content/uploads/2020/01/kapitan-amerika-kartinki-supergeroya-12.jpg",
            Color(62, 79,181)
        ),
        HeroUI(
            97,
            "Spiderman",
            "In iron suit",
            "https://img.goodfon.ru/original/640x960/e/6a/the-amazing-spider-man-endryu.jpg",
            Color(76, 175, 80, 255)
        ),
        HeroUI(
            98,
            "Doctor Strange",
            "Faith is my sword, truth my shield, knowledge my armour",
            "https://i.pinimg.com/originals/77/d2/2c/77d22c7e3251e3dfb7197ff6715802c0.jpg",
            Color(7, 122,82)
        ),
        HeroUI(
            93,
            "Thor",
            "I have much to learn. I know that",
            "https://proprikol.ru/wp-content/uploads/2020/01/tor-kartinki-supergeroya-23.jpg",
            Color(12, 131,186)
        ),
        HeroUI(
            91,
            "Thanos",
            "Fun isn't something when balancing the universe",
            "https://i.pinimg.com/736x/9e/9a/00/9e9a00ae817ceaccd08cd36d24b03c2d.jpg",
            Color(108, 16,197)
        )
    )
    val heroEntitySamples = listOf(
        HeroEntity(
            name = "Deadpool",
            description = "Please don’t make the super suit green...or animated!",
            image = "https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg"
        ),
        HeroEntity(
            name = "Iron Man",
            description = "I AM IRON MAN",
            image = "https://cdn1.ozone.ru/s3/multimedia-q/6630703910.jpg"
        ),
        HeroEntity(
            name = "Captain America",
            description = "I really miss the days when the weirdest thing science ever created was me",
            image = "https://proprikol.ru/wp-content/uploads/2020/01/kapitan-amerika-kartinki-supergeroya-12.jpg"
        ),
        HeroEntity(
            name = "Spiderman",
            description = "In iron suit",
            image = "https://img.goodfon.ru/original/640x960/e/6a/the-amazing-spider-man-endryu.jpg"
        ),
        HeroEntity(
            name = "Doctor Strange",
            description = "Faith is my sword, truth my shield, knowledge my armour",
            image = "https://i.pinimg.com/originals/77/d2/2c/77d22c7e3251e3dfb7197ff6715802c0.jpg"
        ),
        HeroEntity(
            name = "Thor",
            description = "I have much to learn. I know that",
            image = "https://proprikol.ru/wp-content/uploads/2020/01/tor-kartinki-supergeroya-23.jpg"
        ),
        HeroEntity(
            name = "Thanos",
            description = "Fun isn't something when balancing the universe",
            image = "https://i.pinimg.com/736x/9e/9a/00/9e9a00ae817ceaccd08cd36d24b03c2d.jpg"
        )
    )
}