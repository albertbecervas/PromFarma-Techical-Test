package com.abecerra.technicaltestpromofarma.app.di

import com.abecerra.technicaltestpromofarma.domain.usecase.ReposUseCase
import org.koin.dsl.module

object UseCaseModule {

    fun get() = module {
        single { ReposUseCase(get()) }
    }

}