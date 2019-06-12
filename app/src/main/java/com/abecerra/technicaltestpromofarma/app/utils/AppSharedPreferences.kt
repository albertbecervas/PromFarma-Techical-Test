package com.abecerra.technicaltestpromofarma.app.utils

import android.content.SharedPreferences
import com.abecerra.technicaltestpromofarma.app.App
import com.abecerra.technicaltestpromofarma.presentation.data.SortingDirection
import com.abecerra.technicaltestpromofarma.presentation.data.SortingDirection.ASCENDING
import com.abecerra.technicaltestpromofarma.presentation.data.SortingDirection.DESCENDING
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
        return when (mPrefs.getString(SELECTED_SORTING, FULL_NAME.sortTitle)) {
            CREATED.sortTitle -> CREATED
            UPDATED.sortTitle -> UPDATED
            PUSHED.sortTitle -> PUSHED
            else -> FULL_NAME
        }
    }

    fun setSelectedSortingOption(sort: String) {
        mPrefs.edit()
            .putString(SELECTED_SORTING, sort)
            .apply()
    }

    fun getSelectedDirection(): SortingDirection {
        val selected = mPrefs.getString(SELECTED_DIRECTION, DESCENDING.directionValue)
        return if (selected == ASCENDING.directionValue) ASCENDING else DESCENDING
    }

    fun setSelectedDirection(direction: String) {
        mPrefs.edit()
            .putString(SELECTED_DIRECTION, direction)
            .apply()
    }

}