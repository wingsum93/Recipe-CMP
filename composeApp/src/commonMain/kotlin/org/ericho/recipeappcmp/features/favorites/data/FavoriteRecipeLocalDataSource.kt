package org.ericho.recipeappcmp.features.favorites.data

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface FavoriteRecipeLocalDataSource {
    suspend fun getAllFavoriteRecipes(): List<RecipeItem>
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
}