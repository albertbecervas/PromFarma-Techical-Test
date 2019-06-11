package com.abecerra.technicaltestpromofarma.app.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {

    fun formatRepoDate(date: String): Date? {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH)
        return try {
            dateFormat.parse(date)
        } catch (e: Exception) {
            null
        }
    }

}