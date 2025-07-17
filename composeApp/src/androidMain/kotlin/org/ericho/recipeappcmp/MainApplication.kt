package org.ericho.recipeappcmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.ericho.recipeappcmp.dbFactory.DatabaseFactory
import org.ericho.recipeappcmp.di.initKoin
import org.ericho.recipeappcmp.preferences.MultiplatformSettingsFactory

class MainApplication: Application() {

    private val androidModules = module {
        single { DatabaseFactory(applicationContext) }
        single { MultiplatformSettingsFactory(applicationContext) }
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin(additionalModules = listOf(androidModules)) {
            androidContext(applicationContext)
        }
    }
}