package gael.guerra.composepokedex.dummies

import gael.guerra.composepokedex.R
import gael.guerra.composepokedex.domain.Pokemon

//EVOLUCIONES
private val pichu = Pokemon(
    "Pichu",
    172,
    "electric",
    "No controla aún bien la electricidad que genera.",
    0.3f,
    2.0f,
    false,
    "Electricidad Estática",
    R.drawable.pichu
)

private val raichu = Pokemon(
    "Raichu",
    26,
    "electric",
    "Su cola sirve como toma de tierra para descargar electricidad.",
    0.8f,
    30.0f,
    false,
    "Pararrayos",
    R.drawable.raichu
)

private val charmeleon = Pokemon(
    "Charmeleon",
    5,
    "fire",
    "Muy agresivo en combate y de naturaleza feroz.",
    1.1f,
    19.0f,
    false,
    "Mar Llamas",
    R.drawable.charmeleon
)

private val charizard = Pokemon(
    "Charizard",
    6,
    "fire",
    "Escupe fuego tan caliente que derrite rocas.",
    1.7f,
    90.5f,
    false,
    "Mar Llamas",
    R.drawable.charizard
)

private val ivysaur = Pokemon(
    "Ivysaur",
    2,
    "poison",
    "Su bulbo ha crecido y absorbe mucha energía solar.",
    1.0f,
    13.0f,
    false,
    "Espesura",
    R.drawable.ivysaur
)

private val venusaur = Pokemon(
    "Venusaur",
    3,
    "poison",
    "La flor de su espalda libera un aroma relajante.",
    2.0f,
    100.0f,
    false,
    "Espesura",
    R.drawable.venesaur
)
//POKEMONES BASE

val pokemonList = listOf(
    Pokemon("Pikachu", 25, "electric", "Un Pokémon eléctrico muy ágil.", 0.4f, 6.0f, true, "Estática", R.drawable.pikachu, listOf(pichu, raichu)),
    Pokemon("Charmander", 4, "fire", "Prefiere lugares calientes.", 0.6f, 8.5f, false, "Mar Llamas", R.drawable.charma, listOf(charmeleon, charizard)),
    Pokemon(
        "Bulbasaur", 1, "poison",
        "Una semilla fue plantada en su espalda al nacer.",
        0.7f, 6.9f, false, "Espesura", R.drawable.bulbasaur, listOf(ivysaur, venusaur)),
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
    return pokemonList[(0..9).random()]
}

fun getPokemon(id: Int): Pokemon{
    return pokemonList.first { pokemon -> pokemon.number == id }
}

fun getAdjacentPokemon(id: Int): Pair<Pokemon?, Pokemon?> {
    val index = pokemonList.indexOfFirst { it.number == id }
    if (index == -1) return Pair(null, null)

    val previous = pokemonList.getOrNull(index - 1)
    val next = pokemonList.getOrNull(index + 1)
    return Pair(previous, next)
}