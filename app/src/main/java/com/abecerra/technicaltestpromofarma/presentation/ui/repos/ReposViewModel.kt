package com.abecerra.technicaltestpromofarma.presentation.ui.repos

import android.arch.lifecycle.MutableLiveData
import com.abecerra.technicaltestpromofarma.app.base.BaseViewModel
import com.abecerra.technicaltestpromofarma.app.utils.extensions.*
import com.abecerra.technicaltestpromofarma.domain.usecase.ReposUseCase
import com.abecerra.technicaltestpromofarma.presentation.data.Repo
import com.abecerra.technicaltestpromofarma.presentation.data.mapper.RepoMapper
import io.reactivex.disposables.CompositeDisposable

class ReposViewModel(private val reposUseCase: ReposUseCase) : BaseViewModel() {

    val repos = MutableLiveData<Data<List<Repo>>>()

    fun getRepos(sort: String, direction: String, page: Int) {
        reposUseCase.getRepos(sort, direction, page)
            .subscribe({
                repos.showLoading()
            }, {
                repos.updateData(RepoMapper.map(it))
            }, {
                repos.showError(it.message)
            }, CompositeDisposable())
    }

}