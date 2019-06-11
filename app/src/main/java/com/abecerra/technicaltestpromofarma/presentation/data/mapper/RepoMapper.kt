package com.abecerra.technicaltestpromofarma.presentation.data.mapper

import com.abecerra.technicaltestpromofarma.app.base.BaseMapper
import com.abecerra.technicaltestpromofarma.app.utils.DateFormatter
import com.abecerra.technicaltestpromofarma.domain.model.RepoModel
import com.abecerra.technicaltestpromofarma.presentation.data.Repo
import java.util.*

object RepoMapper : BaseMapper<RepoModel, Repo>() {
    override fun map(from: RepoModel): Repo {
        return with(from) {
            Repo(
                name = name,
                fullName = fullName,
                description = description,
                language = language,
                timeSinceLastUpdate = DateFormatter.getElapsedTime(lastUpdated, Date()),
                stars = stars,
                watchers = watchers,
                forks = forks
            )
        }
    }
}