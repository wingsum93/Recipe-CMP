package org.ericho.recipeappcmp.features.feed.data.datasources

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface FeedRemoteDataSource {
    suspend fun getRecipesList(): List<RecipeItem>
}