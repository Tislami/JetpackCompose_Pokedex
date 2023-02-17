package com.zeroone.jetpackcompose_pokedex.domain.model

import androidx.compose.ui.graphics.painter.Painter

data class Pokemon(
    val id: Int = 0,
    val name: String = "",
    val imageUrl: String = "",
    val type: String = "",
    )


val defaultPokemon = Pokemon(
    id = 0,
    name = "Bulbasour",
    imageUrl = "",
    type = "poison"
)

val pokemonList = listOf(
    Pokemon(
        id = 0,
        name = "Bulbasour",
        imageUrl = "",
        type = "poison"
    ),
    Pokemon(
        id = 0,
        name = "Bulbasour",
        imageUrl = "",
        type = "poison"
    ),
    Pokemon(
        id = 0,
        name = "Bulbasour",
        imageUrl = "",
        type = "poison"
    ),Pokemon(
        id = 0,
        name = "Bulbasour",
        imageUrl = "",
        type = "poison"
    ),Pokemon(
        id = 0,
        name = "Bulbasour",
        imageUrl = "",
        type = "poison"
    ),Pokemon(
        id = 0,
        name = "Bulbasour",
        imageUrl = "",
        type = "poison"
    ),Pokemon(
        id = 0,
        name = "Bulbasour",
        imageUrl = "",
        type = "poison"
    ),
)