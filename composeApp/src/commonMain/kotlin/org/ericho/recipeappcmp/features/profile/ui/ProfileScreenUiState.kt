package org.ericho.recipeappcmp.features.profile.ui

import org.ericho.recipeappcmp.features.profile.data.User


data class ProfileScreenUiState(
    val userInfo: User? = null,
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)