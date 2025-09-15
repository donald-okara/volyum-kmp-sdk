/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.components

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

/**
 * A composable function that displays a row of 5 stars for rating input.
 *
 * @param modifier The modifier to apply to this layout.
 * @param rating The current rating value, an integer from 1 to 5.
 * @param onRatingChange A callback function that is invoked when the rating changes.
 *                       It receives the new rating value as an argument.
 */
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

/**
 * Composable function that displays a star icon, which can be either filled or outlined,
 * typically used for rating systems.
 *
 * @param modifier The modifier to be applied to the component.
 * @param size The size of the star icon. Defaults to 40.dp.
 * @param index The index of the star, used for content description when part of a rating system.
 *              If null, a generic "Star Icon" content description is used.
 * @param onClick Lambda function to be invoked when the star is clicked.
 * @param filled A boolean indicating whether the star should be filled (true) or outlined (false).
 */
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
