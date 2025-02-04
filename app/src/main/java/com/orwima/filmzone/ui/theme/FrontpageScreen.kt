@file:OptIn(ExperimentalMaterial3Api::class)

package com.orwima.filmzone.ui.theme


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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

import com.orwima.filmzone.ui.theme.BlueA700

data class Movie(
    val title: String,
    val description: String,
    val genre: String,
    val detailedDescription: String
)

val movies = listOf(
    Movie(
        "Mad Max",
        "A high-octane action film",
        "Action",
        "Set in a dystopian future, 'Mad Max' follows the journey of Max Rockatansky, a road warrior battling gangs in a barren wasteland. The film is filled with stunning car chases, intense fight scenes, and a relentless pace. Max is a man haunted by his tragic past and driven by survival. Along the way, he encounters Furiosa, a fierce warrior with a mission of her own. Together, they must face overwhelming odds to bring hope to a desolate world. The film explores themes of redemption, resilience, and the thin line between survival and humanity."
    ),
    Movie(
        "John Wick",
        "An ex-hitman seeks revenge",
        "Action",
        "John Wick, a retired hitman, is pulled back into the criminal underworld after the tragic loss of his wife and the brutal theft of his car. To make matters worse, the thieves kill the puppy left to him by his late wife. Fueled by grief and vengeance, John embarks on a bloody path against powerful enemies. The film is a visually stunning showcase of intricate fight choreography and dynamic action sequences. It explores themes of loyalty, loss, and the unrelenting pursuit of justice in a dark and unforgiving world."
    ),
    Movie(
        "The Dark Knight",
        "Batman faces his toughest challenge yet",
        "Action",
        "In Christopher Nolan's masterpiece, Gotham City faces a new and terrifying threat: the Joker, a psychopathic criminal mastermind. Batman, with the help of allies Commissioner Gordon and Harvey Dent, must stop the Joker’s reign of chaos. The film delves into moral dilemmas, the nature of heroism, and the sacrifices made for the greater good. With iconic performances and a compelling narrative, 'The Dark Knight' redefined superhero cinema. It explores the complexity of good versus evil and the cost of being a symbol of hope in a world filled with darkness."
    ),
    Movie(
        "Inception",
        "A mind-bending thriller",
        "Sci-Fi",
        "In this science fiction epic, Dom Cobb is a skilled thief specializing in stealing secrets from within the subconscious during dreams. He’s offered a chance to have his criminal record wiped clean if he can accomplish the impossible: inception—implanting an idea into someone’s mind. As Cobb assembles a team for the complex heist, they navigate layered dreamscapes, each with its own dangers. The film challenges perceptions of reality and identity, with breathtaking visuals and a thought-provoking narrative that leaves audiences questioning the nature of their own consciousness."
    ),
    Movie(
        "Interstellar",
        "A journey through space",
        "Sci-Fi",
        "When Earth faces an environmental collapse, a group of astronauts embarks on a daring mission through a wormhole to find a new home for humanity. Led by Cooper, a former pilot turned farmer, the team encounters breathtaking celestial phenomena, alien worlds, and the limits of human endurance. The film weaves together themes of love, sacrifice, and survival, as Cooper’s bond with his daughter drives him through impossible odds. With stunning visuals, an emotional story, and a sweeping score, 'Interstellar' is a celebration of human resilience and curiosity."
    ),
    Movie(
        "The Matrix",
        "A hacker discovers the truth about reality",
        "Sci-Fi",
        "Thomas Anderson, known online as Neo, is a hacker who discovers that the world he knows is a simulated reality called the Matrix. Guided by the enigmatic Morpheus and the fierce Trinity, Neo learns that he may be 'The One,' destined to free humanity from the machines controlling their world. The film is a groundbreaking mix of philosophy, cyberpunk aesthetics, and cutting-edge visual effects. It challenges notions of free will, reality, and identity, all while delivering thrilling action and unforgettable characters. 'The Matrix' redefined science fiction for a new generation."
    ),
    Movie(
        "The Hangover",
        "A comedy about a wild night",
        "Comedy",
        "Three friends wake up in Las Vegas after a bachelor party gone horribly wrong, only to realize the groom is missing. With no memory of the previous night, they retrace their steps to piece together the chaotic events. From a tiger in the bathroom to a mysterious baby in the closet, the trio faces hilarious and outrageous challenges. The film explores themes of friendship, responsibility, and the unpredictability of life, all delivered with sharp humor and memorable performances. 'The Hangover' is a laugh-out-loud comedy that became an instant classic."
    ),
    Movie(
        "Superbad",
        "Teen comedy classic",
        "Comedy",
        "Best friends Seth and Evan are determined to make the most of their last days of high school by securing alcohol for a party and impressing their crushes. Along the way, they encounter eccentric police officers, awkward social situations, and their own insecurities. The film is a heartfelt and hilarious look at friendship, growing up, and the chaos of adolescence. With its witty dialogue and unforgettable characters, 'Superbad' captures the awkward yet endearing moments of teenage life."
    ),
    Movie(
        "Mean Girls",
        "High school drama and comedy",
        "Comedy",
        "Cady Heron, a homeschooled teenager, enters the public school system for the first time and becomes entangled with the Plastics, a clique of popular yet ruthless girls. As she navigates the treacherous waters of high school drama, Cady learns lessons about identity, honesty, and the importance of being true to herself. Filled with witty humor, iconic lines, and relatable characters, 'Mean Girls' has become a cultural phenomenon that satirizes the social structures of adolescence while offering heartfelt moments of growth."
    ),
    Movie(
        "Step Brothers",
        "Two grown men become stepbrothers",
        "Comedy",
        "When their single parents get married, Brennan and Dale, two middle-aged, unemployed men, are forced to live together. Their rivalry turns into a hilarious partnership as they bond over shared interests and absurd antics. The film is a comedic exploration of family dynamics, personal growth, and the joy of embracing one’s inner child. With its outrageous humor and unforgettable moments, 'Step Brothers' delivers laughs while highlighting the importance of finding common ground."
    ),
    Movie(
        "Bridesmaids",
        "A wedding leads to hilarious chaos",
        "Comedy",
        "Annie, a struggling baker, becomes the maid of honor for her best friend Lillian’s wedding. As she tries to plan the perfect events, Annie finds herself at odds with Helen, a wealthy and seemingly perfect bridesmaid. The film is a riotous journey through friendship, rivalry, and the pressure of perfection. With its sharp humor, relatable characters, and heartwarming moments, 'Bridesmaids' redefines the comedy genre by blending outrageous antics with genuine emotional depth."
    ),
    Movie(
        "The Exorcist",
        "A young girl becomes possessed by a demon",
        "Horror",
        "When a young girl named Regan begins exhibiting terrifying and unexplainable behavior, her desperate mother seeks the help of two priests. Father Merrin and Father Karras confront the demonic entity possessing Regan in a battle of faith, willpower, and sacrifice. The film is a harrowing exploration of the supernatural and the fragility of the human spirit. With chilling visuals, haunting performances, and a deeply unsettling atmosphere, 'The Exorcist' remains a cornerstone of the horror genre, exploring themes of belief, redemption, and the power of good versus evil."
    ),
    Movie(
        "Hereditary",
        "A family is haunted by dark secrets",
        "Horror",
        "Annie Graham’s family begins to unravel after the death of her secretive mother. Strange and horrifying events plague the family, revealing a sinister legacy tied to their bloodline. As Annie investigates the truth, she uncovers a web of occult practices and terrifying revelations. The film is an intense psychological horror that delves into themes of grief, mental illness, and familial trauma. With its unsettling imagery, powerful performances, and a chilling narrative, 'Hereditary' is a modern masterpiece that lingers in the minds of viewers long after the credits roll."
    ),
    Movie(
        "A Quiet Place",
        "A family struggles to survive in silence",
        "Horror",
        "In a post-apocalyptic world overrun by sound-sensitive monsters, the Abbott family lives in near-total silence to survive. Every move they make is carefully calculated to avoid detection, but their fragile existence is put at risk when unexpected events occur. The film explores the depths of parental love, sacrifice, and resilience. With minimal dialogue, it relies on powerful visual storytelling and a haunting sound design to create tension. 'A Quiet Place' is a gripping and emotional journey that demonstrates the power of silence in conveying fear and hope."
    ),
    Movie(
        "Seven",
        "Two detectives hunt a serial killer",
        "Thriller",
        "Detectives Somerset and Mills are drawn into a chilling game of cat and mouse with a serial killer who uses the seven deadly sins as inspiration for his gruesome murders. As the case unfolds, the detectives face moral dilemmas, psychological strain, and shocking revelations. The film is a dark and gripping exploration of human nature, justice, and the boundaries of morality. With its bleak atmosphere, compelling performances, and unforgettable ending, 'Seven' is a masterclass in suspense and storytelling."
    ),
    Movie(
        "Gone Girl",
        "A husband becomes a suspect in his wife's disappearance",
        "Thriller",
        "When Amy Dunne goes missing on her fifth wedding anniversary, her husband Nick becomes the prime suspect. As the investigation unfolds, shocking secrets about their marriage come to light. The film is a twisted psychological thriller that keeps viewers guessing until the very end. With its intricate plot, sharp social commentary, and unforgettable characters, 'Gone Girl' explores themes of manipulation, perception, and the complexities of modern relationships. It is a tense and thought-provoking cinematic experience."
    ),
    Movie(
        "Shutter Island",
        "A detective uncovers a dark secret on an island",
        "Thriller",
        "U.S. Marshal Teddy Daniels and his partner Chuck arrive at Ashecliffe Hospital, a mental institution on Shutter Island, to investigate the disappearance of a patient. As Teddy delves deeper into the mystery, he begins to question his own sanity and uncovers shocking truths about the facility and himself. The film is a psychological thriller filled with twists, haunting imagery, and an atmosphere of paranoia. 'Shutter Island' explores themes of guilt, trauma, and the fragility of the human mind in a way that leaves audiences reeling."
    ),
    Movie(
        "The Notebook",
        "A timeless love story",
        "Romance",
        "In a nursing home, an elderly man reads a love story to a woman suffering from memory loss. The story follows Noah and Allie, two young lovers from different social classes who face numerous obstacles to be together. Their enduring love transcends time and hardships, proving the power of true devotion. The film is a heartfelt exploration of love, sacrifice, and the memories that define us. 'The Notebook' captures the beauty of a timeless romance that resonates with viewers of all generations."
    ),
    Movie(
        "Titanic",
        "A tragic love story on the doomed ship",
        "Romance",
        "Set aboard the ill-fated RMS Titanic, the film tells the story of Jack, a free-spirited artist, and Rose, a young woman trapped in an aristocratic life. As their forbidden love blossoms, the ship meets its tragic fate. The film is a sweeping epic that combines historical drama with an intimate love story. With breathtaking visuals, emotional depth, and iconic performances, 'Titanic' explores themes of class, love, and survival in the face of overwhelming tragedy. It remains one of the most beloved films of all time."
    ),
    Movie(
        "Pride and Prejudice",
        "A classic tale of love and misunderstandings",
        "Romance",
        "Set in the Regency era, 'Pride and Prejudice' follows Elizabeth Bennet, an independent and intelligent young woman, as she navigates societal expectations and her complicated feelings for the enigmatic Mr. Darcy. The film is a beautifully crafted adaptation of Jane Austen’s timeless novel, capturing the wit, charm, and emotional depth of the story. Themes of pride, prejudice, and the transformative power of love are explored in a way that continues to resonate with audiences. It is a celebration of love, family, and self-discovery."
    )
)


@Composable
fun Frontpage(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.imagetwo),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            ScreenTitle(title = "FilmZone", subtitle = "Cinema for you.")
            MovieSearchBar("Search for movies!", navController)

            Text("Browse your favorites by genre!",
                fontSize = 22.sp,
                color = BlueA200,
                modifier = Modifier
                    .padding(top = 28.dp))

            MovieCategories(navController)

            HotMoviesCard(navController)
        }
    }
}

@Composable
fun ScreenTitle(title: String, subtitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 132.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 56.sp,
            fontWeight = FontWeight.Bold,
            color = BlueA200,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        Text(
            text = subtitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 38.dp)
        )
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val favorites = remember { mutableStateListOf<Movie>() }

    NavHost(navController, startDestination = "home") {
        composable("home") {
            Frontpage(navController)
        }
        composable("searchResults/{query}") { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            SearchResultsScreen(query, navController, favorites)
        }
        composable("genre/{genre}") { backStackEntry ->
            val genre = backStackEntry.arguments?.getString("genre") ?: ""
            GenreScreen(genre, navController, favorites)
        }

        composable("hot_movies_2025") {
            HotMovies2025Screen(navController)
        }
    }
}
