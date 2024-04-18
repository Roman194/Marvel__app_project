package com.example.marvel_app_project.assets

import androidx.compose.ui.graphics.Color
import com.example.marvel_app_project.data.HeroEntity
import com.example.marvel_app_project.models.UiLayer.HeroUI

object SampleData{
    val heroEntitySamples = listOf(
        HeroEntity(
            serverId = "91",
            name = "Deadpool",
            description = "Please don’t make the super suit green...or animated!",
            image = "https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg"
        ),
        HeroEntity(
            serverId = "92",
            name = "Iron Man",
            description = "I AM IRON MAN",
            image = "https://cdn1.ozone.ru/s3/multimedia-q/6630703910.jpg"
        ),
        HeroEntity(
            serverId = "93",
            name = "Captain America",
            description = "I really miss the days when the weirdest thing science ever created was me",
            image = "https://proprikol.ru/wp-content/uploads/2020/01/kapitan-amerika-kartinki-supergeroya-12.jpg"
        ),
        HeroEntity(
            serverId = "94",
            name = "Spiderman",
            description = "In iron suit",
            image = "https://img.goodfon.ru/original/640x960/e/6a/the-amazing-spider-man-endryu.jpg"
        ),
        HeroEntity(
            serverId = "95",
            name = "Doctor Strange",
            description = "Faith is my sword, truth my shield, knowledge my armour",
            image = "https://i.pinimg.com/originals/77/d2/2c/77d22c7e3251e3dfb7197ff6715802c0.jpg"
        ),
        HeroEntity(
            serverId = "96",
            name = "Thor",
            description = "I have much to learn. I know that",
            image = "https://proprikol.ru/wp-content/uploads/2020/01/tor-kartinki-supergeroya-23.jpg"
        ),
        HeroEntity(
            serverId = "97",
            name = "Thanos",
            description = "Fun isn't something when balancing the universe",
            image = "https://i.pinimg.com/736x/9e/9a/00/9e9a00ae817ceaccd08cd36d24b03c2d.jpg"
        )
    )
}