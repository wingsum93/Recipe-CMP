package org.ericho.recipeappcmp.features.search.domain.repositories

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface SearchRecipeRepository {
    suspend fun searchRecipesByText(query: String): Result<List<RecipeItem>>
}