package com.abecerra.technicaltestpromofarma.app.di

import com.abecerra.technicaltestpromofarma.presentation.ui.repos.ReposViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {

    fun get() = module {
        viewModel { ReposViewModel(get()) }
    }

}