package org.ericho.recipeappcmp

import org.koin.dsl.module
import org.ericho.recipeappcmp.dbFactory.DatabaseFactory
import org.ericho.recipeappcmp.di.initKoin
import org.ericho.recipeappcmp.preferences.MultiplatformSettingsFactory

val iosModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinIOS() = initKoin(additionalModules = listOf(iosModules))
