package com.abecerra.technicaltestpromofarma.domain.model

import java.util.*

data class RepoModel(
    val name: String,
    val fullName: String,
    val description: String,
    val language: String,
    val lastUpdate: Date,
    val stars: Int,
    val watchers: Int,
    val forks: Int
)