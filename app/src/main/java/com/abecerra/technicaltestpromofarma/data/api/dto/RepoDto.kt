package com.abecerra.technicaltestpromofarma.data.api.dto

import com.squareup.moshi.Json

data class RepoDto(
    @Json(name = "name")
    val name: Any?,
    @Json(name = "full_name")
    val fullName: Any?,
    @Json(name = "description")
    val description: Any?,
    @Json(name = "language")
    val language: Any?,
    @Json(name = "updated_at")
    val lastUpdated: Any?,
    @Json(name = "stargazers_count")
    val stars: Any?,
    @Json(name = "watchers_count")
    val watchers: Any?,
    @Json(name = "forks_count")
    val forks: Any?
)