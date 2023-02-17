package com.zeroone.jetpackcompose_pokedex.data.remote

import com.zeroone.jetpackcompose_pokedex.domain.model.Response
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.Pokedex
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.PokedexItem
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchData() : Flow<Response<List<PokedexItem>>>
}