package com.zeroone.jetpackcompose_pokedex.presentation.ui.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.PokedexItem

@Composable
fun PokemonItemView(
    pokemon: PokedexItem,
    onclick : ()-> Unit,
) {
    Surface(
        modifier = Modifier.padding(4.dp).clickable { onclick() },
        shape = RoundedCornerShape(12),
        elevation = 8.dp,
        color = pokemon.getColor()
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 4.dp,
                horizontal = 16.dp
            ),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = pokemon.name.replaceFirstChar { it.uppercase() },
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White.copy(alpha = .35f))
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    text = pokemon.type,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.width(16.dp))

                AsyncImage(
                    model = pokemon.imageUrl, contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}