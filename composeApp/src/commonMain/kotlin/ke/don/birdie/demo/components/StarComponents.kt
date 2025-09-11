package ke.don.birdie.demo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RatingInput(
    modifier: Modifier = Modifier,
    rating: Int,
    onRatingChange: (rating: Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        (1..5).forEach { index ->
            StarSurface(
                onClick = { onRatingChange(index) },
                filled = index <= rating
            )
        }
    }
}

@Composable
fun StarSurface(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    onClick: ()-> Unit,
    filled: Boolean
){
    Surface(
        modifier = Modifier
            .size(size)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Icon(
            imageVector = if (filled) {
                Icons.Filled.StarRate
            } else {
                Icons.Outlined.StarRate
            },
            contentDescription = "Rate star",
            tint = if (filled) MaterialTheme.colorScheme.tertiary
            else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        )
    }
}
