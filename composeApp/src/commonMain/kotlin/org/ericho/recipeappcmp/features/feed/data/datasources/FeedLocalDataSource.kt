package org.ericho.recipeappcmp.features.feed.data.datasources

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface FeedLocalDataSource {
    suspend fun getRecipesList(): List<RecipeItem>
    suspend fun saveRecipesList(recipes: List<RecipeItem>)
}