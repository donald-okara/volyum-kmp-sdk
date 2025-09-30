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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.StarRate
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ke.don.volyum.demo.models.UserData
import io.github.donald_okara.volyum.model.table.Feedback
import io.github.donald_okara.volyum.model.table.FeedbackStatus

/**
 * Displays a single feedback item in a card format.
 *
 * @param item The [Feedback] object containing the data to display.
 * @param modifier Optional [Modifier] for this composable.
 * @param isPreview If true, the feedback text will be truncated to a maximum of 4 lines.
 *                  If false, the full feedback text will be shown.
 * @param onClick A lambda function to be invoked when the card is clicked.
 */
@Composable
fun FeedbackItem(
    item: Feedback,
    modifier: Modifier = Modifier,
    isPreview: Boolean = true,
    onClick: () -> Unit = {},
) {
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            ProfileHeader(
                status = item.status,
                userData = UserData(
                    id = item.userId ?: "",
                    name = item.userMetadata?.username ?: "Anonymous",
                    profileUrl = item.userMetadata?.profileUrl
                        ?: "https://picsum.photos/seed/${item.id ?: "default"}/200",
                ),
            )

            // Rating + timestamp
            RatingRow(
                rating = item.rating ?: 0,
                timestamp = item.formatTimestamp(),
                modifier = Modifier.padding(top = 4.dp),
            )

            // Target type label
            if (item.targetType?.isNotBlank() == true) {
                Text(
                    text = "#${item.targetType}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                )
            }

            // Feedback text
            item.text?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = if (isPreview) 4 else Int.MAX_VALUE,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

/**
 * Displays the user's profile information, including their avatar, name, and feedback status.
 *
 * @param userData The user's data, including their name and profile URL.
 * @param modifier Optional [Modifier] for this composable.
 * @param status The status of the feedback (e.g., Pending, Approved, Rejected).
 */
@Composable
fun ProfileHeader(
    userData: UserData,
    modifier: Modifier = Modifier,
    status: FeedbackStatus = FeedbackStatus.Pending,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        AsyncImage(
            model = userData.profileUrl,
            contentDescription = "Avatar",
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.2f)),
            contentScale = ContentScale.Crop,
        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = userData.name,
            style = MaterialTheme.typography.titleMedium,
        )

        Spacer(modifier = Modifier.weight(1f)) // pushes chip to end

        Surface(
            shape = MaterialTheme.shapes.small,
            tonalElevation = 0.dp,
            border = BorderStroke(
                width = 1.dp,
                color = status.color(),
            ),
            color = Color.Transparent, // outlined look
        ) {
            Text(
                text = status.name,
                style = MaterialTheme.typography.labelSmall,
                color = status.color(),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            )
        }
    }
}

/**
 * A composable function that displays a star rating.
 *
 * @param rating The current rating, an integer between 0 and 5.
 * @param modifier Optional [Modifier] for this composable.
 * @param starSize The size of each star icon. Defaults to 20.dp.
 * @param spacing The spacing between each star icon. Defaults to 2.dp.
 */
@Composable
fun StarRating(
    rating: Int,
    modifier: Modifier = Modifier,
    starSize: Dp = 20.dp,
    spacing: Dp = 2.dp,
) {
    Row(modifier = modifier) {
        for (i in 1..5) {
            val icon = if (i <= rating) Icons.Filled.StarRate else Icons.Outlined.StarRate
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .size(starSize)
                    .padding(end = spacing),
            )
        }
    }
}

/**
 * Composable function that displays a row with a star rating and a timestamp.
 *
 * @param rating The rating to display, as an integer.
 * @param timestamp The timestamp to display, as a string.
 * @param modifier The modifier to apply to this layout node.
 */
@Composable
fun RatingRow(
    rating: Int,
    timestamp: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        StarRating(rating = rating)
        Text(
            text = timestamp,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
