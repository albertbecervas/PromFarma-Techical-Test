package com.abecerra.technicaltestpromofarma.app.di

import android.content.Context
import com.abecerra.technicaltestpromofarma.app.navigator.Navigator
import com.abecerra.technicaltestpromofarma.app.navigator.NavigatorImpl
import org.koin.dsl.module

object NavigatorModule {
    fun get() = module {
        single<Navigator> { (context: Context) -> NavigatorImpl(context) }
    }
}