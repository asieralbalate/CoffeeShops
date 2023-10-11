package com.example.coffeeshops

import android.media.Rating
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Portada(navController: NavHostController) {
    LazyColumn(){
        items(getAboutData()) { card ->
            ItemCard(cardData = card)

        }
    }
}

data class CardData(
    var name:String,
    var adress: String,
    @DrawableRes var photo: Int
)

fun getAboutData(): List<CardData> {
    return listOf(
        CardData(
            "Antico Caffè Greco",
            "St. Italy, Rome",
            R.drawable.images,
        ),
        CardData(
            "Coffee Room",
            "St. Germany, Berlin",
            R.drawable.images1,
        ),
        CardData(
            "Coffee Ibiza",
            "St. Colon, Madrid",
            R.drawable.images2,
        ),
        CardData(
            "Pudding Coffee Shop",
            "St. Diagonal, Barcelona",
            R.drawable.images3,
        ),
        CardData(
            "L'Express",
            "St. Picadilly Circus, London",
            R.drawable.images4,
        ),
        CardData(
            "Coffee Corner",
            "St. Àngel Guimerà",
            R.drawable.images5,
        ),
        CardData(
            "Sweet Cup",
            "St. Kinkerstraat, Amsterdam",
            R.drawable.images6,
        )
    )
}

@Composable
fun ItemCard(cardData: CardData) {
    val peso = 1f
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = cardData.photo),
                contentDescription = "Game Image",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = cardData.name)
            RatingBar()
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = cardData.adress)

            Divider()
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Reserve")
            }
        }
    }
}

@Composable
fun RatingBar (modifier: Modifier = Modifier,
               rating: Int = 0,
               stars: Int = 5,
               starsColor: Color = Color.Black
               ) {

    val unfilledStars = (stars - Math.ceil(rating.toDouble())).toInt()
    val filledStars = Math.floor(rating.toDouble()).toInt()
    Row {
        repeat(filledStars) {
            Icon (imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = starsColor,
                )
        }
        repeat(unfilledStars) {
            Icon (imageVector = Icons.Outlined.Star,
                contentDescription = null
            )
        }
    }

}