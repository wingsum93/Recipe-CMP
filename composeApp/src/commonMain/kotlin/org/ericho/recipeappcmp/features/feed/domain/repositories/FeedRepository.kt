package org.ericho.recipeappcmp.features.feed.domain.repositories

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface FeedRepository {

    suspend fun getRecipesList(): Result<List<RecipeItem>>
}