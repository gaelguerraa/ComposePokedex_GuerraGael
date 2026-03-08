package gael.guerra.composepokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import gael.guerra.composepokedex.dummies.getPokemon
import gael.guerra.composepokedex.dummies.showAllPokemon
import gael.guerra.composepokedex.screens.PokedexMenuScreen
import gael.guerra.composepokedex.screens.PokemonDetailScreen

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList>{ PokedexMenuScreen(showAllPokemon(), {id -> navController.navigate(route = PokemonDetail(id = id))}) }
        composable<PokemonDetail> { backStackEntry ->
            val pokemon: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(getPokemon(pokemon.id)) }
    }
}