package org.ericho.recipeappcmp.dbFactory

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.ericho.recipeappcmp.RecipeAppCmpAppDb
import org.ericho.recipeappcmp.dbFactory.DB_FILE_NAME

actual class DatabaseFactory(
    private val context: Context
) {
    actual suspend fun createDriver(): SqlDriver {
        val schema = RecipeAppCmpAppDb.Schema.synchronous()
        return AndroidSqliteDriver(
            schema, context, DB_FILE_NAME,
            callback = object : AndroidSqliteDriver.Callback(schema) {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    db.setForeignKeyConstraintsEnabled(true)
                }
            }
        )
    }
}