package org.ericho.recipeappcmp.features.search.ui

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

data class SearchScreenState(
    val idle: Boolean = true,
    val success: Boolean = false,
    val error: String? = null,
    val results: List<RecipeItem> = emptyList()
)