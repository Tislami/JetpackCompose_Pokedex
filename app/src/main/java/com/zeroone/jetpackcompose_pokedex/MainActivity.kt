package com.zeroone.jetpackcompose_pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import com.zeroone.jetpackcompose_pokedex.domain.model.defaultPokemon
import com.zeroone.jetpackcompose_pokedex.presentation.screens.home.HomeScreen
import com.zeroone.jetpackcompose_pokedex.presentation.ui.contents.PokemonItemView
import com.zeroone.jetpackcompose_pokedex.presentation.ui.theme.JetpackCompose_PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_PokedexTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeScreen()
                }
            }
        }
    }
}
