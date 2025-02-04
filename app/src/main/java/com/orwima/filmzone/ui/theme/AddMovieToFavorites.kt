package com.orwima.filmzone.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orwima.filmzone.R

@Composable
fun AddMovieToFavorites(movie: Movie, favorites: MutableList<Movie>) {

    Spacer(modifier = Modifier.height(50.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Indigo, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f) .padding(top = 24.dp)) {
                Text(
                    text = movie.title,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = White,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = movie.description,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "Genre: ${movie.genre}",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Film synopsis: \n\n${movie.detailedDescription}",
                    fontSize = 16.sp,
                    color = White
                )
            }
        }


        IconButton(
            onClick = {
                if (favorites.contains(movie)) {
                    favorites.remove(movie)
                } else {
                    favorites.add(movie)
                }
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = if (favorites.contains(movie)) "Remove from Favorites" else "Add to Favorites",
                tint = if (favorites.contains(movie)) Color.Yellow else Color.Gray
            )
        }
    }
}