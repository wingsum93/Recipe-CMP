package org.ericho.recipeappcmp.dbFactory

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import co.touchlab.sqliter.DatabaseConfiguration
import org.ericho.recipeappcmp.RecipeAppCmpAppDb
import org.ericho.recipeappcmp.dbFactory.DB_FILE_NAME


actual class DatabaseFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            RecipeAppCmpAppDb.Schema.synchronous(), DB_FILE_NAME,
            onConfiguration = {
                it.copy(
                    extendedConfig = DatabaseConfiguration.Extended(
                        foreignKeyConstraints = true
                    )
                )
            }
        )
    }
}