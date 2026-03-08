package gael.guerra.composepokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gael.guerra.composepokedex.R

@Composable
fun PokemonHeader(name: String, number: Int, fav: Boolean){
    Row(Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Column() {
            Text(name)
            Text("#${number}", modifier = Modifier.align(Alignment.End))
        }
        Box {
            Image(painter = painterResource(R.drawable.pokeball), "pokeball image", contentScale = ContentScale.Fit, modifier = Modifier.size(130.dp).offset(30.dp, 20.dp))
            Image(painter = painterResource(if(fav)R.drawable.star_filled else R.drawable.star_outline), contentDescription = if(fav) "star filled" else "star outline", modifier = Modifier.align(Alignment.TopEnd))
        }
    }
}