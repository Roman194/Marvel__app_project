package com.example.marvel_app_project

import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.models.Heroes

fun findHeroObject(name: String): Heroes {
    val heroValues = SampleData.heroesSample
    heroValues.forEach { hero ->
        if(hero.name == name){
            return hero
        }
    }
    return heroValues[0]
}