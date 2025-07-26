package org.ericho.recipeappcmp.features.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.ericho.recipeappcmp.features.common.data.api.BASE_IMAGE_URL

@Composable
fun IngredientsList(
    ingredients: List<Pair<String, String>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Ingredients Title
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )

        ingredients.forEachIndexed { _, (name, quantity) ->
            IngredientsItem(name = name, quantity = quantity)
        }
    }
}

@Composable
fun IngredientsItem(
    name: String,
    quantity: String,
    modifier: Modifier = Modifier
) {
    // Ingredient Item
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
//            val encodedName = URLEncoder.encode(name.lowercase(), StandardCharsets.UTF_8.toString())
            AsyncImage(
                model = "$BASE_IMAGE_URL/${name.lowercase()}-small.png",
                contentDescription = "…",
                modifier = Modifier.size(40.dp)
                    .align(Alignment.CenterVertically)
                    .padding(4.dp)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.width(10.dp))
            // 右側文字
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = quantity,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}