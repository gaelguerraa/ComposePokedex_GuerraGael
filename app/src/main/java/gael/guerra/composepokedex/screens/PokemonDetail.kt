package gael.guerra.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import gael.guerra.composepokedex.R
import gael.guerra.composepokedex.components.Ability
import gael.guerra.composepokedex.components.Chip
import gael.guerra.composepokedex.components.PokemonHeader
import gael.guerra.composepokedex.components.PokemonNext
import gael.guerra.composepokedex.domain.Pokemon
import gael.guerra.composepokedex.ui.theme.ComposePokedexTheme
import gael.guerra.composepokedex.ui.theme.ElectricYellow
import gael.guerra.composepokedex.ui.theme.White

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview(){
    ComposePokedexTheme(){
        val pokemon = Pokemon(
            "Pikachu",
            25,
            "Eléctrico",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            0.4f,
            6.0f,
            true,
            "Estática",
            R.drawable.pikachu,
            evolutions = listOf(
                Pokemon("Pichu", 172, "electric", "", 0.3f, 2f, false, "", R.drawable.pikachu),
                Pokemon("Raichu", 26, "electric", "", 0.8f, 30f, false, "", R.drawable.pikachu)
            )
        )
        PokemonDetailScreen(pokemon, Pair(null, null), {})
    }
}

@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    adjacentPokemon: Pair<Pokemon?, Pokemon?>,
    onNavigatePokemon: (id: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(Modifier.background(ElectricYellow, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(
            pokemon = pokemon,
            adjacentPokemon = adjacentPokemon,
            onNavigatePokemon = onNavigatePokemon
        )
    }
}

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    adjacentPokemon: Pair<Pokemon?, Pokemon?>,
    onNavigatePokemon: (id: Int) -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ){
        Image(
            painter = painterResource(pokemon.imagen),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ){
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Chip(pokemon.type, ElectricYellow, Modifier.padding(top = 70.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column {
                            Ability("row", label = "Altura", "${pokemon.height} m")
                            Ability("row", label = "Peso", "${pokemon.weight} kg")
                        }
                        Ability("column", label = "Habilidad", pokemon.ability)
                    }

                    Row(
                        Modifier
                            .fillMaxWidth(0.8f)
                            .padding(25.dp)
                    ) {
                        Text(pokemon.description)
                    }

                    Text(
                        text = "Evoluciones",
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(bottom = 8.dp)
                    )
                }

                items(pokemon.evolutions) { evolution ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(evolution.imagen),
                            contentDescription = evolution.name,
                            modifier = Modifier.size(48.dp),
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            text = evolution.name,
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                }

                item {
                    Row(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        adjacentPokemon.first?.let { previousPokemon ->
                            PokemonNext(
                                position = "left",
                                image = previousPokemon.imagen,
                                name = previousPokemon.name,
                                number = previousPokemon.number,
                                onClick = { onNavigatePokemon(previousPokemon.number) }
                            )
                        }

                        adjacentPokemon.second?.let { nextPokemon ->
                            PokemonNext(
                                position = "right",
                                image = nextPokemon.imagen,
                                name = nextPokemon.name,
                                number = nextPokemon.number,
                                onClick = { onNavigatePokemon(nextPokemon.number) }
                            )
                        }
                    }
                }
            }
        }
    }
}