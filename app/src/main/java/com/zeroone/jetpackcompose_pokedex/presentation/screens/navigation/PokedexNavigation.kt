package com.zeroone.jetpackcompose_pokedex.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zeroone.jetpackcompose_pokedex.presentation.screens.detail.DetailScreen
import com.zeroone.jetpackcompose_pokedex.presentation.screens.home.HomeScreen
import com.zeroone.jetpackcompose_pokedex.presentation.screens.home.PokemonViewModel

@Composable
fun PokedexNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(navController = navController)
        }

        composable(route = "detail/{itemId}",
            arguments = listOf(navArgument("itemId")
            { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 1

            val parentEntry =
                remember(backStackEntry) { navController.getBackStackEntry("home") }
            val parentViewModel = hiltViewModel<PokemonViewModel>(parentEntry)

            DetailScreen(
                navController = navController,
                pokedexItemId = itemId,
                pokemonViewModel = parentViewModel
            )
        }
    }
}