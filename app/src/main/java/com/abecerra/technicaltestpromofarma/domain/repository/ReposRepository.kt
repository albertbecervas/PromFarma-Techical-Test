package com.abecerra.technicaltestpromofarma.domain.repository

import com.abecerra.technicaltestpromofarma.domain.model.RepoModel
import io.reactivex.Single

interface ReposRepository {

    fun getRepos(sort: String, direction: String, page: Int): Single<List<RepoModel>>

}