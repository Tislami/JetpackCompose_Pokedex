package com.zeroone.jetpackcompose_pokedex.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.Pokedex
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.PokedexItem
import com.zeroone.jetpackcompose_pokedex.presentation.ui.contents.PokemonItemView

@Composable
fun HomeScreen(
    pokemonViewModel: PokemonViewModel = hiltViewModel()
) {

    val pokemonList = pokemonViewModel.pokemonList.value


    Scaffold(
        topBar = { HomeTopAppBar() },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier.padding(innerPadding),
                pokemonList = pokemonList
            )
        },
    )
}


@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    pokemonList: List<PokedexItem>
) {
    Column(modifier.fillMaxSize()) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(items = pokemonList) { item ->
                PokemonItemView(pokemon = item)
            }
        }
    }
}