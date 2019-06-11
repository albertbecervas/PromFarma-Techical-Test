package com.abecerra.technicaltestpromofarma.app.utils

import com.abecerra.technicaltestpromofarma.R
import com.abecerra.technicaltestpromofarma.app.utils.extensions.context
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateFormatter {

    private const val DAYS_IN_MONTH: Int = 30
    private const val MONTHS_IN_YEAR: Int = 12

    fun formatRepoDate(date: String): Date? {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH)
        return try {
            dateFormat.parse(date)
        } catch (e: Exception) {
            null
        }
    }

    fun getElapsedTime(startDate: Date?, endDate: Date): String? {
        return startDate?.let {

            val elapsedMillis = endDate.time - startDate.time

            val elapsedMinutes: Long = elapsedMillis / TimeUnit.MINUTES.toMillis(1)
            val elapsedHours: Long = elapsedMillis / TimeUnit.HOURS.toMillis(1)
            val elapsedDays: Long = elapsedMillis / TimeUnit.DAYS.toMillis(1)
            val elapsedMonths: Long = elapsedDays / DAYS_IN_MONTH
            val elapsedYears: Long = elapsedMonths / MONTHS_IN_YEAR

            when {
                elapsedYears != 0L -> context.resources.getQuantityString(R.plurals.elapsed_years, elapsedYears.toInt())
                elapsedMonths != 0L -> context.resources.getQuantityString(
                    R.plurals.elapsed_months,
                    elapsedMonths.toInt()
                )
                elapsedDays != 0L -> context.resources.getQuantityString(R.plurals.elapsed_days, elapsedDays.toInt())
                elapsedHours != 0L -> context.resources.getQuantityString(R.plurals.elapsed_hours, elapsedHours.toInt())
                elapsedMinutes != 0L -> context.resources.getQuantityString(
                    R.plurals.elapsed_minutes,
                    elapsedMinutes.toInt()
                )
                else -> null
            }
        } ?: kotlin.run {
            null
        }
    }


}