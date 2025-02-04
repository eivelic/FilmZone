package com.orwima.filmzone.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.orwima.filmzone.R

@Composable
fun GenreScreen(genre: String, navController: NavController, favorites: MutableList<Movie>) {
    val genreMovies = favorites.filter { it.genre == genre }

    Image(
        painter = painterResource(id = R.drawable.imagetwo),
        contentDescription = "Background Image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Your favorite $genre movies",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = White),
            modifier = Modifier
                .padding(top = 100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        genreMovies.forEach { movie ->
            AddMovieToFavorites(movie, favorites)
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}