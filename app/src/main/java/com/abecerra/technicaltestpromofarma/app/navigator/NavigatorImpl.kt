package com.abecerra.technicaltestpromofarma.app.navigator

import android.content.Context
import com.abecerra.technicaltestpromofarma.presentation.data.Repo
import com.abecerra.technicaltestpromofarma.presentation.ui.repos.detail.ReposDetailActivity
import org.jetbrains.anko.startActivity

class NavigatorImpl(private var context: Context) : Navigator {

    override fun navigateToRepoDetail(repo: Repo) {
        with(context) {
            startActivity<ReposDetailActivity>()
        }
    }

}