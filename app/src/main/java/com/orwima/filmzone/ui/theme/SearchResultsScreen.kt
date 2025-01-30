package com.orwima.filmzone.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.orwima.filmzone.R

@Composable
fun SearchResultsScreen(searchQuery: String, navController: NavController, favorites: MutableList<Movie>) {
    val filteredMovies = movies.filter { it.title.contains(searchQuery, ignoreCase = true) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.imagetwo),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text("Search Results for \"$searchQuery\"", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = White)

            if (filteredMovies.isEmpty()) {
                Text("No movies found.", fontSize = 18.sp, modifier = Modifier.padding(16.dp))
            } else {
                filteredMovies.forEach { movie ->
                    AddMovieToFavorites(movie, favorites)
                }
            }

            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}
