package com.zeroone.jetpackcompose_pokedex.domain.repository

import android.util.Log
import com.zeroone.jetpackcompose_pokedex.data.remote.PokedexApi
import com.zeroone.jetpackcompose_pokedex.data.remote.PokemonRepository
import com.zeroone.jetpackcompose_pokedex.domain.model.Response
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.Pokedex
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.net.SocketTimeoutException

class PokemonRepositoryImpl(
    private val pokedexApi: PokedexApi
) : PokemonRepository {

    override suspend fun fetchData() = flow {
        emit(Response.Loading)
        try {
            val data = pokedexApi.getData().filterNotNull()
            emit(Response.Success(data))
        } catch (e: HttpException) {
            emit(Response.Error("Oops something is wrong in getting data: ${e.message}"))
        } catch (e: SocketTimeoutException) {
            emit(Response.Error("Oops something is wrong in getting data: ${e.message}"))
        }
    }

}