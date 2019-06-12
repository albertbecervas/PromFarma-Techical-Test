package com.abecerra.technicaltestpromofarma.presentation.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.abecerra.technicaltestpromofarma.R
import com.abecerra.technicaltestpromofarma.app.base.BaseActivity
import com.abecerra.technicaltestpromofarma.app.utils.extensions.rotate
import com.abecerra.technicaltestpromofarma.presentation.data.SortingDirection.ASCENDING
import com.abecerra.technicaltestpromofarma.presentation.data.SortingDirection.DESCENDING
import com.abecerra.technicaltestpromofarma.presentation.data.SortingOptions
import com.abecerra.technicaltestpromofarma.presentation.ui.repos.ReposFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : BaseActivity() {

    private val reposFragment = ReposFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            it.clear()
            SortingOptions.values().forEach { sort ->
                it.add(sort.sortTitle)
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            mPrefs.setSelectedSortingOption(it.title.toString())
            reposFragment.onSortSettingsChanged()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setViews() {
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.flRepos, reposFragment)
            .commit()

        setSortDirection()

        ivDirection.visibility = View.VISIBLE
        ivDirection.setOnClickListener {
            ivDirection.rotate()
            updateSortDirection()
            reposFragment.onSortSettingsChanged()
        }
    }

    private fun setSortDirection() {
        ivDirection.rotation = when (mPrefs.getSelectedDirection()) {
            ASCENDING -> 180f
            DESCENDING -> 0f
        }
    }

    private fun updateSortDirection() {
        when (mPrefs.getSelectedDirection()) {
            ASCENDING -> mPrefs.setSelectedDirection(DESCENDING.directionValue)
            DESCENDING -> mPrefs.setSelectedDirection(ASCENDING.directionValue)
        }
    }
}
