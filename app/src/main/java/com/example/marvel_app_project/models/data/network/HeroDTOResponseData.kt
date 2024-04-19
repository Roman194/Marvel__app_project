package com.example.marvel_app_project.models.data.network

import com.squareup.moshi.Json

data class HeroDTOResponseData(
    @Json(name = "results")
    val result: List<HeroMoshi>
)
