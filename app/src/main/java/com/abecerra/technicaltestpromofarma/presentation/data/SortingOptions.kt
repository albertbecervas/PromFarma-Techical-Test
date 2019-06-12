package com.abecerra.technicaltestpromofarma.presentation.data

enum class SortingOptions(val sortTitle: String, val sortValue: String) {
    CREATED("Created", "created"), UPDATED("Updated", "updated"),
    PUSHED("Pushed", "pushed"), FULL_NAME("Full name", "full_name")
}