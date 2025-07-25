package org.ericho.recipeappcmp.features.common.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import recipeapp_cmp.composeapp.generated.resources.Res
import recipeapp_cmp.composeapp.generated.resources.snail_loading

@Composable
fun SnailLoader() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painterResource(Res.drawable.snail_loading),
            contentDescription = "Snail Loader",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
