package com.zeroone.jetpackcompose_pokedex.data.remote

import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.Pokedex
import retrofit2.http.GET


interface PokedexApi {
    @GET("pokemon.json")
    suspend fun getData() : Pokedex
}