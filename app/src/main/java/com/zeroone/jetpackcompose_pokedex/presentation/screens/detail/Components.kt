package com.zeroone.jetpackcompose_pokedex.presentation.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.zeroone.jetpackcompose_pokedex.R
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.EvolutionChain

@Composable
fun AboutTextField(
    title: String,
    power: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
    ) {
        Text(
            modifier = Modifier.weight(.40f),
            text = title,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.60f),
            text = power,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color.Black
        )
    }
}


@Composable
fun BaseStatsBarField(
    title: String,
    power: Int,
) {
    val density = LocalDensity.current
    var width by remember { mutableStateOf(0.dp) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(.30f),
            text = title,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )



        Row(
            modifier = Modifier
                .weight(.70f)
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "$power",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned {
                            val maxWidth = with(density) { it.size.width.toDp() }
                            width = power * maxWidth / 100
                        }
                        .clip(RoundedCornerShape(4.dp)),
                    thickness = 8.dp,
                    color = Color.Gray.copy(alpha = 0.5f)
                )

                Divider(
                    Modifier
                        .width(width)
                        .clip(RoundedCornerShape(4.dp)),
                    color = if (power >= 50) Color.Green else Color.Red,
                    thickness = 8.dp
                )
            }
        }
    }
}

@Composable
fun EvolutionField(pokemon: EvolutionChain) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray.copy(alpha = .25f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = pokemon.name.replaceFirstChar { it.uppercase() },
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Image(
            painter = painterResource(id = R.drawable.bulbasaur),
            contentDescription = null
        )
    }
}
