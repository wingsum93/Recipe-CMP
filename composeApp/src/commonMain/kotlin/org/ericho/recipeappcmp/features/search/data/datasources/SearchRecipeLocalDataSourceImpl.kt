package org.ericho.recipeappcmp.features.search.data.datasources

import org.ericho.recipeappcmp.features.common.data.database.daos.RecipeDao
import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

class SearchRecipeLocalDataSourceImpl(
    private val recipeDao: RecipeDao
): SearchRecipeLocalDataSource {
    override suspend fun searchRecipesByText(query: String): List<RecipeItem> {
        return recipeDao.searchRecipesByText(query)
    }
}