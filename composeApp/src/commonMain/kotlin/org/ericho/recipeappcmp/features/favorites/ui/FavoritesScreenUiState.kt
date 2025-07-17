package org.ericho.recipeappcmp.features.favorites.ui

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

data class FavoritesScreenUiState(
    val itemsList: List<RecipeItem>? = null,
    val itemsListIsLoading: Boolean = true,
    val itemsListError: String? = null,
)