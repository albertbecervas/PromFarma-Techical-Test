package com.abecerra.technicaltestpromofarma.data.repository

import com.abecerra.technicaltestpromofarma.app.utils.PaginationScrollListener.Companion.PAGE_SIZE
import com.abecerra.technicaltestpromofarma.data.api.ReposService
import com.abecerra.technicaltestpromofarma.data.api.dto.mapper.RepoDtoMapper
import com.abecerra.technicaltestpromofarma.domain.model.RepoModel
import com.abecerra.technicaltestpromofarma.domain.repository.ReposRepository
import io.reactivex.Single

class ReposRepositoryImpl(private val api: ReposService) : ReposRepository {

    override fun getRepos(sort: String, direction: String, page: Int): Single<List<RepoModel>> {
        return api.getRepos(page, PAGE_SIZE, sort, direction).map {
            RepoDtoMapper.map(it)
        }
    }

}