package com.zeroone.jetpackcompose_pokedex.presentation.ui.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zeroone.jetpackcompose_pokedex.R
import com.zeroone.jetpackcompose_pokedex.domain.model.Pokemon
import com.zeroone.jetpackcompose_pokedex.domain.model.defaultPokemon

@Composable
fun PokemonItemView(
    pokemon: Pokemon
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(12),
        elevation = 8.dp,
        color = Color(76, 175, 80, 255),
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 4.dp,
                horizontal = 16.dp
            ),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = pokemon.name,
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

                Image(
                    painter = painterResource(id = R.drawable.bulbasaur),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}