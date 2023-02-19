package com.zeroone.jetpackcompose_pokedex.presentation.screens.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.PokedexItem
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.defaultPokedexItem
import com.zeroone.jetpackcompose_pokedex.presentation.screens.home.PokemonViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    pokedexItemId : Int,
    pokemonViewModel: PokemonViewModel,
) {
    val pokedexItem = pokemonViewModel.getPokemon(pokedexItemId)
    Scaffold(
        topBar = {
            DetailTopBar(
                navigationOnClick = { navController.popBackStack() },
                actionOnClick = {},
                color = pokedexItem.getColor()
            )
        },
        content = { innerPadding ->
            DetailContent(
                modifier = Modifier.padding(innerPadding),
                pokedexItem = pokedexItem,
                navigateToPokemonDetail = {
                    navController.navigate("detail/$it")
                }
            )
        },
    )
}


@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
    navigateToPokemonDetail : (Int) -> Unit,
    pokedexItem: PokedexItem
) {

    val tabs = listOf("About", "Base Stats", "Evolution")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(pokedexItem.getColor()),
    ) {
        Head(pokedexItem)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color.White)
        ) {
            TabRow(
                modifier = Modifier
                    .height(65.dp)
                    .padding(top = 32.dp),
                selectedTabIndex = selectedTabIndex,
                backgroundColor = Color.White,
                contentColor = pokedexItem.getColor()
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.Gray
                    ) {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                        )
                    }
                }
            }

            when (selectedTabIndex) {
                0 -> About(pokedexItem = pokedexItem)
                1 -> BaseStats(pokedexItem = pokedexItem)
                2 -> Evolution(pokedexItem = pokedexItem, onClick = navigateToPokemonDetail)
            }
        }
    }
}


@Composable
private fun Head(pokedexItem: PokedexItem) {
    Column(
        modifier = Modifier.zIndex(1.1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(top = 32.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = pokedexItem.name.replaceFirstChar { it.uppercase() },
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White.copy(alpha = .35f))
                        .padding(horizontal = 12.dp, vertical = 2.dp),
                    text = pokedexItem.type,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Text(
                text = "#00${pokedexItem.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        }

        AsyncImage(
            model = pokedexItem.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .offset(y = (25).dp)
                .size(175.dp)
        )
    }
}

@Composable
private fun Evolution(
    onClick : (Int) -> Unit,
    pokedexItem: PokedexItem,
) {
    
    LazyRow(modifier = Modifier.padding(vertical = 32.dp)) {
        items(pokedexItem.evolutionChain) { pokemon ->

            var pokemon =
            EvolutionField(pokemon,onClick,pokedexItem.getColor(),pokedexItem.imageUrl)
        }
    }
}

@Composable
private fun BaseStats(pokedexItem: PokedexItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .padding(start = 32.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseStatsBarField(title = "Hp", power = pokedexItem.attack)
        BaseStatsBarField(title = "Attack", power = pokedexItem.attack)
        BaseStatsBarField(title = "Defense", power = pokedexItem.defense)
        BaseStatsBarField(title = "Sp. Atk", power = pokedexItem.attack)
        BaseStatsBarField(title = "Sp. Def", power = pokedexItem.defense)
        BaseStatsBarField(title = "Speed", power = pokedexItem.attack)
        BaseStatsBarField(title = "Total", power = pokedexItem.defense)
    }
}

@Composable
private fun About(pokedexItem: PokedexItem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.padding(start = 32.dp, bottom = 32.dp)) {
            AboutTextField("Species", pokedexItem.height.toString())
            AboutTextField("Height", pokedexItem.height.toString())
            AboutTextField("Weight", pokedexItem.weight.toString())
            AboutTextField("Abilities", pokedexItem.weight.toString())
        }

        Text(
            text = pokedexItem.description,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
    }
}

