package com.abecerra.technicaltestpromofarma.app.di

import com.abecerra.technicaltestpromofarma.data.repository.ReposRepositoryImpl
import com.abecerra.technicaltestpromofarma.domain.repository.ReposRepository
import org.koin.dsl.module

object RepositoryModule {

    fun get() = module {
        single<ReposRepository> { ReposRepositoryImpl(get()) }
    }

}