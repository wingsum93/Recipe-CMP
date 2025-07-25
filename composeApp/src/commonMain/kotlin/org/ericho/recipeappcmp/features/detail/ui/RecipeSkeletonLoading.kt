package org.ericho.recipeappcmp.features.detail.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RecipeSkeletonLoading() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.3f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnim, translateAnim),
        end = Offset(translateAnim + 200f, translateAnim + 200f)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        // 大圖 Shimmer
        ShimmerBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(brush)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Title Shimmer
        ShimmerBox(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(24.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(brush)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Stars + Difficulty Shimmer
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(3) {
                ShimmerBox(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(brush)
                )
            }
            ShimmerBox(
                modifier = Modifier
                    .width(40.dp)
                    .height(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Description Shimmer
        repeat(2) {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(14.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Ingredients Shimmer
        repeat(8) {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Instructions Shimmer
        repeat(10) {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(14.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

@Composable
fun ShimmerBox(modifier: Modifier) {
    Box(modifier = modifier)
}

@Preview
@Composable
fun RecipeSkeletonLoadingPreview() {
    RecipeSkeletonLoading()
}

