package org.ericho.recipeappcmp.features.detail.data.datasources

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface RecipeDetailRemoteDataSource {

    suspend fun getRecipeDetail(id: Long): RecipeItem?

}