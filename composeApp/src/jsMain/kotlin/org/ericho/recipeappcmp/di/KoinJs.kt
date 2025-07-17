package org.ericho.recipeappcmp.di

import org.koin.dsl.module
import org.ericho.recipeappcmp.dbFactory.DatabaseFactory
import org.ericho.recipeappcmp.preferences.MultiplatformSettingsFactory

val jsModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinJs() = initKoin(additionalModules = listOf(jsModules))
