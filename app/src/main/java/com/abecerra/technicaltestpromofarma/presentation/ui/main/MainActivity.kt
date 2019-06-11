package com.abecerra.technicaltestpromofarma.presentation.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.abecerra.technicaltestpromofarma.R
import com.abecerra.technicaltestpromofarma.app.base.BaseActivity
import com.abecerra.technicaltestpromofarma.presentation.data.SortingOptions
import com.abecerra.technicaltestpromofarma.presentation.ui.repos.ReposFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            it.clear()
            SortingOptions.values().forEach { sort ->
                it.add(sort.sortValue)
            }
        }
        menuInflater.inflate(R.menu.sort_menu, menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            if (it.itemId == R.id.direction) {

            } else {
                mPrefs.setSelectedSortingOption(it.title.toString())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setViews() {
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.flRepos, ReposFragment())
            .commit()
    }
}
