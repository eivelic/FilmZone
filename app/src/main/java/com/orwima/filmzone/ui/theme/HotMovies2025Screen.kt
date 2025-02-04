package com.orwima.filmzone.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.orwima.filmzone.R

@Composable
fun HotMoviesCard(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate("hot_movies_2025")
            },
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.imageone),
                contentDescription = "Pozadina za 2025 movie ekran",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "\uD83D\uDD25 HOT MOVIES OF 2025 \uD83D\uDD25",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Grey300,
                    modifier = Modifier
                        .padding(top = 130.dp)
                )
            }
        }
    }
}

@Composable
fun HotMovies2025Screen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.imageone),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Check out the hot takes!",
                modifier = Modifier
                    .padding(top = 120.dp),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
            )
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 90.dp)
                    .padding(end = 90.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Pre-Order Now!",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .padding(top = 30.dp)
                        .background(Color(0xff616161), RoundedCornerShape(10.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Back in Action",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White // Bijeli tekst za bolji kontrast
                            )
                        )
                        Text(
                            text = "PG-13, (1h 54min)",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = White
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 20.dp)
                        )
                        Text(
                            text = "Former CIA spies Emily and Matt are pulled back into espionage after their secret identities are exposed.",
                            modifier = Modifier
                                .padding(bottom = 15.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "⭐⭐⭐⭐ Rating: 7.9 (33K)",
                            style = TextStyle(
                                color = White,

                                )
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .padding(top = 30.dp)
                        .background(Color(0xff616161), RoundedCornerShape(10.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Wolf Man",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "PG-13, (1h 43min)",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = White
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 20.dp)
                        )
                        Text(
                            text = "A family at a remote farmhouse is attacked by an unseen animal, but as the night stretches on, the father begins to transform into something unrecognizable.",
                            modifier = Modifier
                                .padding(bottom = 15.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "⭐⭐⭐ Rating: 5.9 (9K)",
                            style = TextStyle(
                                color = White,

                                )
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .padding(top = 30.dp)
                        .background(Color(0xffef9a9a), RoundedCornerShape(10.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Captain America: Brave New World",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "PG-13, (1h 58min) - In Theaters February, 2025",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = White
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 20.dp)
                        )
                        Text(
                            text = "Sam Wilson, the new Captain America, finds himself in the middle of an international incident and must discover the motive behind a nefarious global plan.",
                            modifier = Modifier
                                .padding(bottom = 15.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "No Rating (Provided by Metascore)",
                            style = TextStyle(
                                color = White,

                                )
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .padding(top = 30.dp)
                        .background(Color(0xff616161), RoundedCornerShape(10.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Flight Risk",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "PG-13, (1h 54min)",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = White
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 20.dp)
                        )
                        Text(
                            text = "A pilot transports an Air Marshal accompanying a fugitive to trial. As they cross the Alaskan wilderness, tensions soar and trust is tested, as not everyone on board is who they seem.",
                            modifier = Modifier
                                .padding(bottom = 15.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "⭐⭐⭐⭐⭐ Rating: 9.7 (3.7K)",
                            style = TextStyle(
                                color = White,

                                )
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .padding(top = 30.dp)
                        .background(Color(0xff616161), RoundedCornerShape(10.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Mickey 17",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "(2h 9min)",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = White
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 20.dp)
                        )
                        Text(
                            text = "Mickey 17, known as an \"expendable,\" goes on a dangerous journey to colonize an ice planet.",
                            modifier = Modifier
                                .padding(bottom = 15.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "⭐⭐⭐⭐⭐ Rating: 9.1 (25)",
                            style = TextStyle(
                                color = White,

                                )
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .padding(top = 30.dp)
                        .background(Color(0xff616161), RoundedCornerShape(10.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Star Trek: Section 31",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "PG-13, (1h 35min)",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = White
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 20.dp)
                        )
                        Text(
                            text = "In Star Trek: Section 31, Emperor Philippa Georgiou joins a secret division of Starfleet tasked with protecting the United Federation of Planets, and must face the sins of her past.",
                            modifier = Modifier
                                .padding(bottom = 15.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "⭐⭐ Rating: 3.9 (7.5K)",
                            style = TextStyle(
                                color = White,

                                )
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .padding(top = 30.dp)
                        .background(Color(0xff616161), RoundedCornerShape(10.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "One of Them Days",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "(1h 37min)",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = White
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 20.dp)
                        )
                        Text(
                            text = "When best friends and roommates Dreux and Alyssa discover Alyssa's boyfriend has blown their rent money, the duo finds themselves going to extremes in a race against the clock to avoid eviction and keep their friendship intact.",
                            modifier = Modifier
                                .padding(bottom = 15.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "⭐⭐⭐ Rating: 7.1 (2.3K)",
                            style = TextStyle(
                                color = White,

                                )
                        )
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))


                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 100.dp)
                ) {
                    Text("Back")
                }

            }
        }
    }
}