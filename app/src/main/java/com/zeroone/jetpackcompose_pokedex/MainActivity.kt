package com.zeroone.jetpackcompose_pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.defaultPokedexItem
import com.zeroone.jetpackcompose_pokedex.presentation.screens.detail.DetailScreen
import com.zeroone.jetpackcompose_pokedex.presentation.screens.home.HomeScreen
import com.zeroone.jetpackcompose_pokedex.presentation.ui.theme.JetpackCompose_PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_PokedexTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DetailScreen(defaultPokedexItem)
                    //HomeScreen()
                }
            }
        }
    }
}
