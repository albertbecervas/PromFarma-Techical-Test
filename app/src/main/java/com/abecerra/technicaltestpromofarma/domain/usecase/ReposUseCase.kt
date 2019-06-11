package com.abecerra.technicaltestpromofarma.domain.usecase

import com.abecerra.technicaltestpromofarma.domain.repository.ReposRepository

class ReposUseCase(private val reposRepository: ReposRepository) {

    fun getRepos(sort: String, direction: String, page: Int) = reposRepository.getRepos(sort, direction, page)

}