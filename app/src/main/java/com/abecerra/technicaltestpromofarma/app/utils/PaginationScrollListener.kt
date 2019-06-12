package com.abecerra.technicaltestpromofarma.app.utils

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

abstract class PaginationScrollListener(private val layoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {

    private var currentPage = 1
    private var lastTotalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && !isLastPage(totalItemCount)) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                && firstVisibleItemPosition >= 0
                && totalItemCount >= PAGE_SIZE
            ) {
                lastTotalItemCount = totalItemCount
                currentPage += 1
                loadMoreItems(currentPage)
            }
        }

    }

    abstract fun loadMoreItems(page: Int)

    abstract fun isLoading(): Boolean

    private fun isLastPage(totalItemCount: Int): Boolean = lastTotalItemCount == totalItemCount

    fun reset() {
        currentPage = 1
    }

    companion object {
        const val PAGE_SIZE = 10
    }

}