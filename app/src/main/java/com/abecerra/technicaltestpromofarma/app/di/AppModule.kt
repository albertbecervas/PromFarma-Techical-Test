package com.abecerra.technicaltestpromofarma.app.di

import com.abecerra.technicaltestpromofarma.app.utils.AppSharedPreferences
import org.koin.dsl.module

object AppModule {

    fun get() =
        listOf(
            ViewModelModule.get(),
            UseCaseModule.get(),
            RepositoryModule.get(),
            ApiModule.get(),
            NavigatorModule.get(),
            module { single { AppSharedPreferences.getInstance() } }
        )
}