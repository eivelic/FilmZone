package com.orwima.filmzone.ui.theme

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MovieCategories(navController: NavController) {
    val categories = listOf("Action", "Thriller", "Horror", "Comedy", "Romance", "Sci-Fi")

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 15.dp)
            .fillMaxWidth()
    ) {
        categories.chunked(2)
            .forEach { row ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                        .padding(end = 20.dp)
                ) {
                    row.forEach { category ->
                        TabButton(
                            text = category,
                            isActive = false,
                            onClick = { navController.navigate("genre/$category") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(bottom = 8.dp)
                        )
                    }
                }
            }
    }
}

@Composable
fun TabButton(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color(0xff0288d1)),
        border = BorderStroke(1.dp, Color.White),
        modifier = modifier,
        onClick = { onClick() },
    ) {
        Text(text)
    }
}