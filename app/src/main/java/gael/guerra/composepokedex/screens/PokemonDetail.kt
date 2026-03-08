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
            R.drawable.pikachu
        )
        PokemonDetailScreen(pokemon)
    }
}


@Composable
fun PokemonDetailScreen(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(Modifier.background(ElectricYellow, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(
            pokemon.name,
            pokemon.weight,
            pokemon.height,
            pokemon.description,
            pokemon.ability,
            pokemon.type,
            pokemon.imagen
        )

    }
}


@Composable
fun PokemonCard(name: String, weight: Float, height: Float, description: String, ability: String, type: String, image: Int, modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxWidth(),contentAlignment = Alignment.TopCenter){
        Image(painter = painterResource(image), contentDescription = name,
            Modifier.offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp)
            ,contentScale = ContentScale.Fit)
        Card(Modifier.fillMaxWidth()
            .fillMaxHeight()
            , elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            , colors = CardDefaults.cardColors( containerColor = White)){
            Column(Modifier.fillMaxWidth()) {
                Chip(type, ElectricYellow,
                    Modifier.padding(top = 70.dp)
                        .align(Alignment.CenterHorizontally))

                Row(modifier = Modifier.fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Column{
                        Ability("row", label = "Altura", "${height} m")
                        Ability("row", label = "Peso", "${weight} kg")
                    }
                    Ability("column", label = "Habilidad", ability)
                }
                Row(Modifier.fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(25.dp)) {
                    Text(description)
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(Modifier.fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PokemonNext(
                        position = "left",
                        image = R.drawable.snorlax,
                        name = "snorlax",
                        number = 24
                    )
                    PokemonNext(
                        position = "right",
                        image = R.drawable.charma,
                        name = "charmander",
                        number = 26
                    )
                }
            }

        }
    }
}