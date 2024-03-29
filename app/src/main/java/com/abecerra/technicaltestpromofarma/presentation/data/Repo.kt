package com.abecerra.technicaltestpromofarma.presentation.data

import java.io.Serializable

data class Repo(
    val name: String,
    val fullName: String,
    val description: String,
    val language: String,
    val timeSinceLastUpdate: String?,
    val stars: Int,
    val watchers: Int,
    val forks: Int
) : Serializable