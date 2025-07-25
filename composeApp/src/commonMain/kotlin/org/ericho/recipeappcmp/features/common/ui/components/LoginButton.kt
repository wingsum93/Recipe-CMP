package org.ericho.recipeappcmp.features.common.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    state: LoginButtonState = LoginButtonState.NORMAL
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(48.dp, 56.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = { if (state != LoginButtonState.LOADING) onClick() },
        enabled = state != LoginButtonState.LOADING
    ) {
        when (state) {
            LoginButtonState.LOADING -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(28.dp),
                    color = Color.White,
                    strokeWidth = 3.dp
                )
            }

            LoginButtonState.SUCCESS -> {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Success",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp) // ✅ Success Icon 放大
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Login Successful",
                        fontSize = 18.sp, // ✅ 文字變大
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            LoginButtonState.ERROR -> {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Error,
                        contentDescription = "Error",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp) // ✅ Success Icon 放大
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Login Failed", fontSize = 18.sp, // ✅ 文字變大
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            else -> {
                Text(
                    "Login", fontSize = 18.sp, // ✅ 文字變大
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
