package org.ericho.recipeappcmp.features.search.data.datasources

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface SearchRecipeLocalDataSource {
    suspend fun searchRecipesByText(query: String): List<RecipeItem>
}