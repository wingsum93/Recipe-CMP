package org.ericho.recipeappcmp.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import org.ericho.recipeappcmp.features.common.data.database.DbHelper
import org.ericho.recipeappcmp.features.common.data.database.daos.FavoriteRecipeDao
import org.ericho.recipeappcmp.features.common.data.database.daos.RecipeDao
import kotlin.coroutines.CoroutineContext

fun cacheModule()  = module {

    single<CoroutineContext> { Dispatchers.Default }
    single { CoroutineScope(get()) }

    single { DbHelper(get()) }
    single { RecipeDao(get()) }
    single { FavoriteRecipeDao(get()) }
}