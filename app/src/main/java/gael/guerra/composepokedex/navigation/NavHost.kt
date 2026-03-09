package gael.guerra.composepokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import gael.guerra.composepokedex.dummies.getAdjacentPokemon
import gael.guerra.composepokedex.dummies.getPokemon
import gael.guerra.composepokedex.dummies.showAllPokemon
import gael.guerra.composepokedex.screens.PokedexMenuScreen
import gael.guerra.composepokedex.screens.PokemonDetailScreen

private data class UserCredentials(val username: String, val password: String)

@Composable
fun MyApp(){
    val navController = rememberNavController()
    val users = remember {
        mutableStateListOf(
            UserCredentials(username = "admin", password = "1234"),
        )
    }

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                onLogin = { username, password ->
                    users.any { it.username == username && it.password == password }
                },
                onLoginSuccess = {
                    navController.navigate(route = PokemonList) {
                        popUpTo(Login) { inclusive = true }
                    }
                },
                onGoToRegister = {
                    navController.navigate(route = Register)
                },
            )
        }

        composable<Register> {
            RegisterScreen(
                onRegister = { username, password, repeatPassword ->
                    when {
                        username.isBlank() || password.isBlank() || repeatPassword.isBlank() ->
                            "Todos los campos son obligatorios"

                        password.length < 4 -> "La contraseña debe tener al menos 4 caracteres"
                        password != repeatPassword -> "Las contraseñas no coinciden"
                        users.any { it.username.equals(username, ignoreCase = true) } ->
                            "Ese usuario ya existe"

                        else -> {
                            users.add(UserCredentials(username = username, password = password))
                            null
                        }
                    }
                },
                onRegisterSuccess = {
                    navController.navigate(route = PokemonList) {
                        popUpTo(Login) { inclusive = true }
                    }
                },
                onBackToLogin = {
                    navController.popBackStack()
                },
            )
        }

        composable<PokemonList> {
            PokedexMenuScreen(showAllPokemon()) { id ->
                navController.navigate(route = PokemonDetail(id = id))
            }
        }

        composable<PokemonDetail> { backStackEntry ->
            val pokemon: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(
                pokemon = getPokemon(pokemon.id),
                adjacentPokemon = getAdjacentPokemon(pokemon.id),
                onNavigatePokemon = { selectedId ->
                    navController.navigate(route = PokemonDetail(id = selectedId))
                }
            )
        }
    }
}