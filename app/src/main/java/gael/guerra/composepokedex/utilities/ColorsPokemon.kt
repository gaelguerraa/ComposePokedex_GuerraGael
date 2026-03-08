package gael.guerra.composepokedex.utilities

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import gael.guerra.composepokedex.domain.Pokemon
import gael.guerra.composepokedex.ui.theme.Bug
import gael.guerra.composepokedex.ui.theme.Electric
import gael.guerra.composepokedex.ui.theme.Fairy
import gael.guerra.composepokedex.ui.theme.Fight
import gael.guerra.composepokedex.ui.theme.Fire
import gael.guerra.composepokedex.ui.theme.Flying
import gael.guerra.composepokedex.ui.theme.Ghost
import gael.guerra.composepokedex.ui.theme.Ground
import gael.guerra.composepokedex.ui.theme.Normal
import gael.guerra.composepokedex.ui.theme.Poison
import gael.guerra.composepokedex.ui.theme.Psych
import gael.guerra.composepokedex.ui.theme.Rock
import gael.guerra.composepokedex.ui.theme.Water
import gael.guerra.composepokedex.ui.theme.White

fun getColorByType(pokemon: Pokemon): Pair<Color, Color> {
    var color: Color = Color.White
    var dark = true

    when {
        pokemon.type.lowercase().contains("normal") -> color = Normal
        pokemon.type.lowercase().contains("electric") -> {
            color = Electric
            dark = false
        }

        pokemon.type.lowercase().contains("water") -> {
            color = Water
        }

        pokemon.type.lowercase().contains("fire") -> color = Fire
        pokemon.type.lowercase().contains("fairy") -> {
            color = Fairy
            dark = false
        }

        pokemon.type.lowercase().contains("electric") -> {
            color = Electric
            dark = false
        }

        pokemon.type.lowercase().contains("psychic") -> {
            color = Psych
        }

        pokemon.type.lowercase().contains("fighting") -> {
            color = Fight
            dark = false
        }

        pokemon.type.lowercase().contains("ghost") -> color = Ghost
        pokemon.type.lowercase().contains("bug") -> color = Bug
        pokemon.type.lowercase().contains("poison") -> color = Poison
        pokemon.type.lowercase().contains("ground") -> color = Ground
        pokemon.type.lowercase().contains("rock") -> color = Rock
        pokemon.type.lowercase().contains("flying") -> {
            color = Flying
            dark = false
        }
    }

    val textColor = if (dark) Color.White else Color.Black
    return Pair(color, textColor)
}