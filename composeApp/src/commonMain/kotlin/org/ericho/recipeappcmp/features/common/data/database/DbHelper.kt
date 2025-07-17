package org.ericho.recipeappcmp.features.common.data.database

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.ericho.recipeappcmp.RecipeAppCmpAppDb
import org.ericho.recipeappcmp.dbFactory.DatabaseFactory
import orgsunildhiman90recipeappcmp.Recipe

class DbHelper(
    private val driverFactory: DatabaseFactory
) {

    private var db: RecipeAppCmpAppDb? = null
    private val mutex = Mutex()

    suspend fun <Result : Any?> withDatabase(block: suspend (RecipeAppCmpAppDb) -> Result) =
        mutex.withLock {
            if (db == null) {
                db = createDb(driverFactory)
            }

            return@withLock block(db!!)
        }

    private suspend fun createDb(driverFactory: DatabaseFactory): RecipeAppCmpAppDb {
        return RecipeAppCmpAppDb(
            driver = driverFactory.createDriver(),
            RecipeAdapter = Recipe.Adapter(
                ingredientsAdapter = listOfStringsAdapter,
                instructionsAdapter = listOfStringsAdapter
            )
        )
    }
}