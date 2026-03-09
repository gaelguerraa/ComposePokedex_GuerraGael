package gael.guerra.composepokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonNext(
    position: String,
    image: Int,
    name: String,
    number: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val normalizedPosition = position.lowercase()

    Column(
        modifier = modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = name,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(70.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (normalizedPosition == "left") {
                ArrowBubble(arrow = "◀")
            }

            Text(
                text = "$name N.º ${number.toString().padStart(4, '0')}",
                color = Color(0xFF4B4F57),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            if (normalizedPosition == "right") {
                ArrowBubble(arrow = "▶")
            }
        }
    }
}

@Composable
private fun ArrowBubble(arrow: String) {
    Box(
        modifier = Modifier
            .size(34.dp)
            .clip(androidx.compose.foundation.shape.CircleShape)
            .background(Color(0xFF4B4F57)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = arrow, color = Color.White)
    }
}