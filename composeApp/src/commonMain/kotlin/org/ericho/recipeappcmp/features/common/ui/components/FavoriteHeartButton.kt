package org.ericho.recipeappcmp.features.common.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteHeartButton(
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    onToggle: (Boolean) -> Unit = {}
) {
    // --- 放大動畫控制 ---
    val scale = remember { Animatable(1f) }

    LaunchedEffect(isFavorite) {
        if (isFavorite) {
            scale.animateTo(
                targetValue = 1.4f,
                animationSpec = tween(150, easing = LinearOutSlowInEasing)
            )
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(150, easing = FastOutLinearInEasing)
            )
        }
    }

    IconButton(
        onClick = { onToggle(!isFavorite) },
        modifier = modifier
            .sizeIn(30.dp, 48.dp)
            .background(
                color = MaterialTheme.colorScheme.background.copy(
                    alpha = 0.8f
                ),
                shape = CircleShape
            )
    ) {
        Icon(
            modifier = Modifier.scale(scale.value),
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = "Favorite",
            tint = if (isFavorite) Color.Red else MaterialTheme.colorScheme.onBackground
        )
    }
}
