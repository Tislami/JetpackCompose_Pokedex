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
import com.zeroone.jetpackcompose_pokedex.domain.model.pokemonList
import com.zeroone.jetpackcompose_pokedex.presentation.ui.contents.PokemonItemView

@Composable
fun HomeScreen() {


    Scaffold(
        topBar = { HomeTopAppBar() },
        content = { innerPadding ->
                  HomeContent(modifier = Modifier.padding(innerPadding))
        },
    )
}


@Composable
fun HomeContent(modifier: Modifier= Modifier) {
    Column(modifier.fillMaxSize()) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp)
        ) {
            items( items = pokemonList) { item ->
                PokemonItemView(pokemon = item)
            }
        }
    }
}