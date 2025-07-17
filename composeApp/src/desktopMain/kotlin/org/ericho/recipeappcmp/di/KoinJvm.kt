package org.ericho.recipeappcmp.di

import org.koin.dsl.module
import org.ericho.recipeappcmp.dbFactory.DatabaseFactory
import org.ericho.recipeappcmp.preferences.MultiplatformSettingsFactory

val jvmModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinJvm() = initKoin(additionalModules = listOf(jvmModules))
