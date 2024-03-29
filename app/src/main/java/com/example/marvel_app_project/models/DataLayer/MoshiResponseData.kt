package com.example.marvel_app_project.models.DataLayer

import com.example.marvel_app_project.models.DataLayer.HeroMoshi
import com.squareup.moshi.Json

data class MoshiResponseData(
    @Json(name = "results")
    val result: List<HeroMoshi>
)
