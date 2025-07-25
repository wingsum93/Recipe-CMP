package org.ericho.recipeappcmp.features.feed.ui

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FeedSkeletonLoading(modifier: Modifier = Modifier) {
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

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        /** ---------- Top Recommendations ---------- **/
        item {
            // Title
            ShimmerBox(
                modifier = Modifier
                    .width(180.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Horizontal scrollable row
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(6) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ShimmerBox(
                            modifier = Modifier
                                .size(120.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(brush)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ShimmerBox(
                            modifier = Modifier
                                .width(80.dp)
                                .height(16.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(brush)
                        )
                    }
                }
            }
        }

        /** ---------- Recipes of the Week ---------- **/
        item {
            // Title
            ShimmerBox(
                modifier = Modifier
                    .width(200.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush)
            )
        }

        items(4) { // 模擬 4 個項目
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                repeat(2) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        ShimmerBox(
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(brush)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ShimmerBox(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .height(16.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(brush)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShimmerBox(modifier: Modifier) {
    Box(modifier = modifier)
}
