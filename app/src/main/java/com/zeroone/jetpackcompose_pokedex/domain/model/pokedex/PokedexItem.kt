package com.zeroone.jetpackcompose_pokedex.domain.model.pokedex

import android.util.Log
import androidx.compose.ui.graphics.Color

data class PokedexItem(
    val attack: Int = 0,
    val defense: Int = 0,
    val description: String = "",
    val evolutionChain: List<EvolutionChain> = emptyList(),
    val height: Int = 0,
    val id: Int = 0,
    val imageUrl: String = "",
    val name: String = "",
    val type: String = "",
    val weight: Int = 0,
) {
    fun getColor() : Color{
        return when (type) {
                "fire" -> Color(233, 30, 99, 255)
                "poison" -> Color(76, 175, 80, 255)
                "water" -> Color(63, 81, 181, 255)
                "electric" -> Color(255, 193, 7, 255)
                "psychic" -> Color(111, 111, 111, 255)
                "normal" -> Color(255, 152, 0, 255)
                "ground" -> Color.Gray
                "flying" -> Color(3, 169, 244, 255)
                "fairy" -> Color(103, 58, 183, 255)
                else -> Color(0, 150, 136, 255)
            }
    }
}