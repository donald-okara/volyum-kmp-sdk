/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ke.don.volyum.demo.components.EmptyScreenMessage
import ke.don.volyum.demo.components.FeedbackItem
import ke.don.volyum.demo.components.FeedbackItemShimmer
import ke.don.volyum.demo.models.DemoIntentHandler
import ke.don.volyum.demo.models.FeedbackState

/**
 * Composable function that displays the details of a feedback item.
 *
 * This screen shows the feedback item itself and any closing remarks. It also handles loading and error states.
 * A dismiss button is provided to close the details view.
 *
 * @param modifier Modifier for this composable.
 * @param state The current state of the feedback details, containing information like loading status, error messages, and the feedback item itself.
 * @param handleIntent A lambda function to handle user intents, specifically to dismiss the details view.
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FeedbackDetailsScreen(
    modifier: Modifier = Modifier,
    state: FeedbackState = FeedbackState(),
    handleIntent: (DemoIntentHandler) -> Unit,
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxHeight(),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AnimatedContent(
                targetState = state.readIsLoading,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
                label = "DetailsLoadingAnim",
            ) { isLoading ->
                when {
                    isLoading -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(4.dp),
                        ) {
                            item { FeedbackItemShimmer() }
                        }
                    }

                    state.readIsError -> {
                        // Empty state message
                        EmptyScreenMessage(
                            title = "Something went wrong",
                            message = state.readErrorMessage ?: "Unknown error",
                            icon = Icons.Default.Info,
                        )
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                        ) {
                            item {
                                FeedbackItem(
                                    item = state.readFeedback,
                                    isPreview = false,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 8.dp),
                                )
                            }
                            state.readFeedback.closingRemarks?.let { text ->
                                item {
                                    ClosingRemarksComponent(
                                        text = text,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 16.dp, vertical = 8.dp),
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Dismiss "X" button
            IconButton(
                onClick = { handleIntent(DemoIntentHandler.ShowDetails) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Dismiss",
                )
            }
        }
    }
}

/**
 * Composable function to display closing remarks for a feedback item.
 *
 * This component displays a title "Closing Remarks" followed by the provided text content
 * within a styled Surface.
 *
 * @param modifier Optional [Modifier] to be applied to the root Column of this component.
 * @param text The string content of the closing remarks to be displayed.
 */
@Composable
fun ClosingRemarksComponent(
    modifier: Modifier = Modifier,
    text: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp),
    ) {
        Text(
            text = "Closing Remarks",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
            ),
            modifier = Modifier.padding(bottom = 8.dp),
        )
        Surface(
            tonalElevation = 2.dp,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                ),
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
