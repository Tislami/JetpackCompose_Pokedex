package com.zeroone.jetpackcompose_pokedex.di

import com.zeroone.jetpackcompose_pokedex.data.remote.PokedexApi
import com.zeroone.jetpackcompose_pokedex.data.remote.PokemonRepository
import com.zeroone.jetpackcompose_pokedex.domain.repository.PokemonRepositoryImpl
import com.zeroone.jetpackcompose_pokedex.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokedexApi(): PokedexApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokedexApi::class.java)

    @Provides
    @Singleton
    fun providePokemonRepository(pokedexApi: PokedexApi) =
        PokemonRepositoryImpl(pokedexApi = pokedexApi)
}