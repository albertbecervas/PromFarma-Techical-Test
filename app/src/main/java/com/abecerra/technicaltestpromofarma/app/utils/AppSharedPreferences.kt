package com.abecerra.technicaltestpromofarma.app.utils

import android.content.SharedPreferences
import com.abecerra.technicaltestpromofarma.app.App
import com.abecerra.technicaltestpromofarma.presentation.data.Direction
import com.abecerra.technicaltestpromofarma.presentation.data.Direction.ASCENDING
import com.abecerra.technicaltestpromofarma.presentation.data.Direction.DESCENDING
import com.abecerra.technicaltestpromofarma.presentation.data.SortingOptions
import com.abecerra.technicaltestpromofarma.presentation.data.SortingOptions.*

class AppSharedPreferences {

    private val mPrefs: SharedPreferences = App.getAppContext().getSharedPreferences(MY_PREFS, 0)

    companion object {

        const val MY_PREFS: String = "MY_PREFS"
        const val SELECTED_SORTING: String = "SELECTED_SORTING"
        const val SELECTED_DIRECTION: String = "SELECTED_DIRECTION"

        private var INSTANCE: AppSharedPreferences? = null

        fun getInstance(): AppSharedPreferences {
            if (INSTANCE == null) INSTANCE = AppSharedPreferences()
            return INSTANCE!!
        }
    }

    fun getSelectedSortingOption(): SortingOptions {
        val selected = mPrefs.getString(SELECTED_SORTING, FULL_NAME.sortValue)
        return when (selected) {
            CREATED.sortValue -> CREATED
            UPDATED.sortValue -> UPDATED
            PUSHED.sortValue -> PUSHED
            else -> FULL_NAME
        }
    }

    fun setSelectedSortingOption(sort: String) {
        mPrefs.edit()
            .putString(SELECTED_SORTING, sort)
            .apply()
    }

    fun getSelectedDirection(): Direction {
        val selected = mPrefs.getString(SELECTED_DIRECTION, ASCENDING.directionValue)
        return if (selected == ASCENDING.directionValue) ASCENDING else DESCENDING
    }

    fun setSelectedDirection(direction: String) {
        mPrefs.edit()
            .putString(SELECTED_DIRECTION, direction)
            .apply()
    }

}