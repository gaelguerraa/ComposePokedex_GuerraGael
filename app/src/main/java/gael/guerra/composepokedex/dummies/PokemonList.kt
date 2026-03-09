package gael.guerra.composepokedex.dummies

import gael.guerra.composepokedex.R
import gael.guerra.composepokedex.domain.Pokemon

val pokemonList = listOf(
    Pokemon("Pikachu", 25, "electric", "Un Pokémon eléctrico muy ágil.", 0.4f, 6.0f, true, "Estática", R.drawable.pikachu),
    Pokemon("Charmander", 4, "fire", "Prefiere lugares calientes.", 0.6f, 8.5f, false, "Mar Llamas", R.drawable.charma),
    Pokemon(
        "Bulbasaur", 1, "poison",
        "Una semilla fue plantada en su espalda al nacer.",
        0.7f, 6.9f, false, "Espesura", R.drawable.bulbasaur),
    Pokemon("Squirtle", 7, "water",
        "Se protege con su resistente caparazón.",
        0.5f, 9.0f, false, "Torrente", R.drawable.squirtle),

    Pokemon("Jigglypuff", 39, "ghost",
        "Canta una melodía que duerme a sus rivales.",
        0.5f, 5.5f, false, "Gran Encanto", R.drawable.jigglypuff),

    Pokemon("Meowth", 52, "bug",
        "Ama las monedas brillantes.",
        0.4f, 4.2f, false, "Recogida", R.drawable.meowth),

    Pokemon("Psyduck", 54, "ground",
        "Siempre tiene dolor de cabeza.",
        0.8f, 19.6f, false, "Humedad", R.drawable.psyduck),

    Pokemon("Eevee", 133, "bug",
        "Tiene un ADN inestable que le permite evolucionar.",
        0.3f, 6.5f, true, "Fuga", R.drawable.eevee),

    Pokemon("Snorlax", 143, "ground",
        "Duerme casi todo el día.",
        2.1f, 460.0f, false, "Inmunidad", R.drawable.snorlax),

    Pokemon("Gengar", 94, "poison",
        "Se esconde en las sombras para asustar.",
        1.5f, 40.5f, false, "Levitación", R.drawable.gengar)
)

fun showAllPokemon(): List<Pokemon> {
    return pokemonList
}

fun returnOnePokemon(): Pokemon{
    return pokemonList.get((0..9).random())
}

fun getPokemon(id: Int): Pokemon{
    return pokemonList.filter { pokemon -> pokemon.number == id }.get(0)
}