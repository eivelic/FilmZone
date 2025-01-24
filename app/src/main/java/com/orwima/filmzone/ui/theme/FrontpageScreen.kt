@file:OptIn(ExperimentalMaterial3Api::class)

package com.orwima.filmzone.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.orwima.filmzone.R

data class Movie(
    val title: String,
    val description: String,
    val genre: String
)

val movies = listOf(
    Movie("Mad Max", "A high-octane action film", "Action"),
    Movie("John Wick", "An ex-hitman seeks revenge", "Action"),
    Movie("The Dark Knight", "Batman faces his toughest challenge yet", "Action"),
    Movie("Inception", "A mind-bending thriller", "Sci-Fi"),
    Movie("Interstellar", "A journey through space", "Sci-Fi"),
    Movie("The Matrix", "A hacker discovers the truth about reality", "Sci-Fi"),
    Movie("The Hangover", "A comedy about a wild night", "Comedy"),
    Movie("Superbad", "Teen comedy classic", "Comedy"),
    Movie("Mean Girls", "High school drama and comedy", "Comedy"),
    Movie("Step Brothers", "Two grown men become stepbrothers", "Comedy"),
    Movie("Bridesmaids", "A wedding leads to hilarious chaos", "Comedy"),
    Movie("The Exorcist", "A young girl becomes possessed by a demon", "Horror"),
    Movie("Hereditary", "A family is haunted by dark secrets", "Horror"),
    Movie("A Quiet Place", "A family struggles to survive in silence", "Horror"),
    Movie("Seven", "Two detectives hunt a serial killer", "Thriller"),
    Movie("Gone Girl", "A husband becomes a suspect in his wife's disappearance", "Thriller"),
    Movie("Shutter Island", "A detective uncovers a dark secret on an island", "Thriller"),
    Movie("The Notebook", "A timeless love story", "Romance"),
    Movie("Titanic", "A tragic love story on the doomed ship", "Romance"),
    Movie("Pride and Prejudice", "A classic tale of love and misunderstandings", "Romance")
)


@Composable
fun ScreenTitle(title: String, subtitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = subtitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

@Composable
fun Frontpage(navController: NavController, favorites: MutableList<Movie>) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.imagetwo),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.6f
        )

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            ScreenTitle(title = "FilmZone", subtitle = "Cinema for you.")
            MovieSearchBar("Search for movies!", navController)

            Text("Favorites", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))

            favorites.groupBy { it.genre }.forEach { (genre, movies) ->
                if (movies.isNotEmpty()) {
                    Text("$genre Movies", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
                    movies.forEach { movie ->
                        MovieItem(movie, favorites)  // Prikazujemo samo filmove koji su u favoritima
                    }
                }
            }

            MovieCategories(navController, favorites)  // Prosljeđujemo favorites ovdje
        }
    }
}


@Composable
fun MovieCategories(navController: NavController, favorites: MutableList<Movie>) {
    val categories = listOf("Action", "Thriller", "Horror", "Comedy", "Romance", "Sci-Fi")

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 15.dp)
            .fillMaxWidth()
    ) {
        categories.chunked(3).forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { category ->
                    TabButton(
                        text = category,
                        isActive = false,
                        onClick = { navController.navigate("genre/$category") },
                        modifier = Modifier.weight(1f)
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
        elevation = null,
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color(0xff0288d1)),
        border = BorderStroke(1.dp, Color.White),
        modifier = modifier,
        onClick = { onClick() },
    ) {
        Text(text)
    }
}

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
            unfocusedLabelColor = Color(0xff2962ff),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color(0xFFFCE4EC), shape = RoundedCornerShape(8.dp))
    )
}

@Composable
fun MovieItem(movie: Movie, favorites: MutableList<Movie>) {
    val isFavorite = favorites.contains(movie)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = movie.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = movie.description, fontSize = 16.sp, fontWeight = FontWeight.Normal, maxLines = 2, overflow = TextOverflow.Ellipsis)
            Text(text = "Genre: ${movie.genre}", fontSize = 14.sp, color = Color.Gray)
        }

        IconButton(onClick = {
            if (favorites.contains(movie)) {
                favorites.remove(movie)  // Uklanjamo film iz favorita
            } else {
                favorites.add(movie)  // Dodajemo film u favorite
            }
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = if (favorites.contains(movie)) "Remove from Favorites" else "Add to Favorites",
                tint = if (favorites.contains(movie)) Color.Yellow else Color.Gray
            )
        }
    }
}


@Composable
fun SearchResultsScreen(searchQuery: String, navController: NavController, favorites: MutableList<Movie>) {
    val filteredMovies = movies.filter { it.title.contains(searchQuery, ignoreCase = true) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.imagetwo),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.6f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text("Search Results for \"$searchQuery\"", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            if (filteredMovies.isEmpty()) {
                Text("No movies found.", fontSize = 18.sp, modifier = Modifier.padding(16.dp))
            } else {
                filteredMovies.forEach { movie ->
                    MovieItem(movie, favorites)
                }
            }

            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}

@Composable
fun GenreScreen(genre: String, navController: NavController, favorites: MutableList<Movie>) {
    val genreMovies = favorites.filter { it.genre == genre }  // Prikazujemo samo filmove koji su u favoritima

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Movies in $genre",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(16.dp))

        genreMovies.forEach { movie ->
            MovieItem(movie, favorites)  // Prikazujemo samo filmove iz favorita
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val favorites = remember { mutableStateListOf<Movie>() }

    NavHost(navController, startDestination = "home") {
        composable("home") { Frontpage(navController, favorites) }
        composable("searchResults/{query}") { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            SearchResultsScreen(query, navController, favorites)
        }
        composable("genre/{genre}") { backStackEntry ->
            val genre = backStackEntry.arguments?.getString("genre") ?: ""
            GenreScreen(genre, navController, favorites)
        }
    }
}