package com.abecerra.technicaltestpromofarma.presentation.ui.repos

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abecerra.technicaltestpromofarma.R
import com.abecerra.technicaltestpromofarma.app.base.BaseFragment
import com.abecerra.technicaltestpromofarma.app.utils.PaginationScrollListener
import com.abecerra.technicaltestpromofarma.app.utils.extensions.Data
import com.abecerra.technicaltestpromofarma.app.utils.extensions.DataState.*
import com.abecerra.technicaltestpromofarma.app.utils.extensions.observe
import com.abecerra.technicaltestpromofarma.presentation.data.Repo
import kotlinx.android.synthetic.main.content_repos.*
import kotlinx.android.synthetic.main.fragment_repos.*
import org.koin.android.viewmodel.ext.android.viewModel


class ReposFragment : BaseFragment() {

    private val viewModel: ReposViewModel by viewModel()

    private var adapter: ReposAdapter? = null

    private var scrollListener: PaginationScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(viewModel.repos, ::updateRepos)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews(view)
    }

    override fun onResume() {
        super.onResume()
        getRepos()
    }

    private fun setViews(view: View) {

        swipeRefreshLayout.setOnRefreshListener {
            getRepos()
        }

        adapter = ReposAdapter {
            navigator.navigateToRepoDetail(it)
        }
        val layoutManager = LinearLayoutManager(view.context)
        rvRepos.layoutManager = layoutManager
        rvRepos.adapter = adapter

        scrollListener = object : PaginationScrollListener(layoutManager) {
            override fun loadMoreItems(page: Int) {
                getRepos(page)
            }

            override fun isLoading(): Boolean {
                return this@ReposFragment.isLoading()
            }

        }
        scrollListener?.let {
            rvRepos.addOnScrollListener(it)
        }

        getRepos()
    }

    private fun getRepos(page: Int = 1) {
        if (isInitialPage(page)) {
            adapter?.clear()
            scrollListener?.reset()
        }
        viewModel.getRepos(
            mPrefs.getSelectedSortingOption().sortValue,
            mPrefs.getSelectedDirection().directionValue,
            page
        )
    }

    private fun isInitialPage(page: Int) = page == 1

    private fun stopRefreshing() {
        swipeRefreshLayout?.let { swipeLayout ->
            swipeLayout.isRefreshing = false
        }
    }

    private fun updateRepos(data: Data<List<Repo>>?) {
        data?.let {
            when (it.dataState) {
                LOADING -> {
                    showLoading()
                }
                SUCCESS -> {
                    it.data?.let { repos ->
                        adapter?.addItems(repos)
                    }
                    hideLoading()
                    stopRefreshing()
                }
                ERROR -> {
                    showError(it.message)
                    hideLoading()
                    stopRefreshing()
                }
            }
        }
    }

}
