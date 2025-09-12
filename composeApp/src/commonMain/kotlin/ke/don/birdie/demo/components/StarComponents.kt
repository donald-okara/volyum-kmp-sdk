/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
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
    onRatingChange: (rating: Int) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        (1..5).forEach { index ->
            StarSurface(
                index = index,
                onClick = { onRatingChange(index) },
                filled = index <= rating,
            )
        }
    }
}

@Composable
fun StarSurface(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    index: Int? = null,
    onClick: () -> Unit,
    filled: Boolean,
) {
    Surface(
        modifier = modifier
            .size(size)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp,
        color = MaterialTheme.colorScheme.surface,
    ) {
        Icon(
            imageVector = if (filled) {
                Icons.Filled.StarRate
            } else {
                Icons.Outlined.StarRate
            },
            contentDescription = if (index == null) "Star Icon" else if (filled) "Rated $index stars" else "Rate $index stars",
            tint = if (filled) {
                MaterialTheme.colorScheme.tertiary
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
        )
    }
}
