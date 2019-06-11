package com.abecerra.technicaltestpromofarma.data.api.dto.mapper

import com.abecerra.technicaltestpromofarma.app.base.BaseMapper
import com.abecerra.technicaltestpromofarma.app.utils.DateFormatter
import com.abecerra.technicaltestpromofarma.app.utils.extensions.toInt
import com.abecerra.technicaltestpromofarma.app.utils.extensions.toString
import com.abecerra.technicaltestpromofarma.data.api.dto.RepoDto
import com.abecerra.technicaltestpromofarma.domain.model.RepoModel

object RepoDtoMapper : BaseMapper<RepoDto, RepoModel>() {
    override fun map(from: RepoDto): RepoModel {
        return with(from) {
            RepoModel(
                name = name.toString(),
                fullName = fullName.toString(),
                description = description.toString(),
                language = language.toString(),
                lastUpdated = DateFormatter.formatRepoDate(lastUpdated.toString()),
                stars = stars.toInt(),
                watchers = watchers.toInt(),
                forks = forks.toInt()
            )
        }
    }
}