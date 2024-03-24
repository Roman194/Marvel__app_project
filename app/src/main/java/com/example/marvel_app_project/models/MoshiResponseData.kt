package com.example.marvel_app_project.models

import com.squareup.moshi.Json

data class MoshiResponseData(
    @Json(name = "results")
    val result: List<HeroMoshi>
)
