package com.orwima.filmzone.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    labelText: String,
    navController: NavController
) {
    var searchInput by remember { mutableStateOf("") }

    TextField(
        value = searchInput,
        onValueChange = { searchInput = it },
        label = { Text(labelText) },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                if (searchInput.isNotBlank()) {
                    navController.navigate("searchResults/$searchInput")
                }
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            unfocusedTextColor = Color(0xff2962ff),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(
                Color(0xFFFCE4EC),
                shape = RoundedCornerShape(8.dp))
    )
}