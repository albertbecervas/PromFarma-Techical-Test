package com.abecerra.technicaltestpromofarma.presentation.ui.repos.detail

import android.os.Bundle
import android.view.MenuItem
import com.abecerra.technicaltestpromofarma.R
import com.abecerra.technicaltestpromofarma.app.base.BaseActivity
import com.abecerra.technicaltestpromofarma.presentation.data.Repo
import kotlinx.android.synthetic.main.content_repo_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ReposDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos_detail)

        setViews()

        getRepo()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getRepo() {
        val repo = intent.getSerializableExtra(REPO_EXTRA) as? Repo
        repo?.let {
            updateRepo(it)
        }
    }

    private fun updateRepo(it: Repo) {
        with(it) {
            tvName.text = fullName
            tvDescription.text = description
            tvStars.text = stars.toString()
            tvForks.text = getString(R.string.forks, forks)
            tvWatchers.text = getString(R.string.watchers, watchers)
        }
    }

    companion object {
        const val REPO_EXTRA: String = "repo_extra"
    }
}
