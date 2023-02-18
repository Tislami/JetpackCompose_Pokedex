package com.zeroone.jetpackcompose_pokedex.presentation.screens.home

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeroone.jetpackcompose_pokedex.data.remote.PokemonRepository
import com.zeroone.jetpackcompose_pokedex.domain.model.Response
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.Pokedex
import com.zeroone.jetpackcompose_pokedex.domain.model.pokedex.PokedexItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepo: PokemonRepository
) : ViewModel() {

    var pokemonList = mutableStateOf(listOf<PokedexItem>())
        private set

    val isLoading = mutableStateOf(false)

    init { fetchData() }

    private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    private fun fetchData(){
        viewModelScope.launch {
            pokemonRepo.fetchData().collect{response->
                when(response){
                    is Response.Error -> {
                        isLoading.value = false
                        _uiEvent.emit(UIEvent.Error(response.message))
                    }
                    is Response.Loading -> { isLoading.value=true }
                    is Response.Success -> {
                        pokemonList.value = response.data

                        Log.d("PokedexAppTag", "fetchData: ${response.data[0]}")
                    }
                }
            }
        }
    }
}

sealed class UIEvent {
    data class Error(val message: String) : UIEvent()
}