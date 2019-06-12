package com.abecerra.technicaltestpromofarma.app

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.abecerra.technicaltestpromofarma.BuildConfig
import com.abecerra.technicaltestpromofarma.app.di.AppModule
import org.koin.core.context.startKoin
import timber.log.Timber

class App : MultiDexApplication() {

    companion object {

        lateinit var INSTANCE: App

        fun getAppContext(): App = INSTANCE

        fun get(context: Context): App {
            return context.applicationContext as App
        }

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            modules(AppModule.get())
        }
    }


    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}