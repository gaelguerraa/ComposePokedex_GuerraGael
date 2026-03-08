package gael.guerra.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import gael.guerra.composepokedex.components.PokemonHeader
import gael.guerra.composepokedex.domain.Pokemon
import gael.guerra.composepokedex.navigation.MyApp
import gael.guerra.composepokedex.screens.PokemonCard
import gael.guerra.composepokedex.ui.theme.ComposePokedexTheme
import gael.guerra.composepokedex.ui.theme.ElectricYellow

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon(name = "Pikachu", number = 25, type = "Eléctrico",
        description = "Pikachu es el mejor pokemon.", height = 0.4f, weight = 6f, fav = true,
        ability = "Estática", imagen = R.drawable.pikachu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                MyApp()
            }
        }
    }
}


@Composable
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(Modifier.background(ElectricYellow, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(pokemon.name,pokemon.weight, pokemon.height, pokemon.description, pokemon.ability, pokemon.type, pokemon.imagen)

    }
}

