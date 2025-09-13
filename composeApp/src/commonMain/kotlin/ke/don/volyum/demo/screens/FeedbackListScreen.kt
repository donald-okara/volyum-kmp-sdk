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
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ke.don.volyum.demo.components.EmptyScreenMessage
import ke.don.volyum.demo.components.FeedbackItem
import ke.don.volyum.demo.components.FeedbackItemShimmer
import ke.don.volyum.demo.models.DemoIntentHandler
import ke.don.volyum.demo.models.EventFeature
import ke.don.volyum.demo.models.FeedbackState
import ke.don.volyum.demo.models.UserData
import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.volyum.feedback.model.table.FeedbackStatus

/**
 * Displays a list of feedback items with filtering and loading states.
 *
 * @param modifier Modifier for customizing the layout.
 * @param state The current state of the feedback list, including loading status, error messages, and the list of feedback items.
 * @param handleIntent A function to handle user intents, such as updating filters or fetching feedback.
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FeedbackList(
    modifier: Modifier = Modifier,
    state: FeedbackState,
    handleIntent: (DemoIntentHandler) -> Unit,
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxHeight(),
    ) {
        AnimatedContent(
            targetState = state.listIsLoading,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
            label = "ListLoadingAnim",
        ) { isLoading ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(4.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                // Pinned filter row
                stickyHeader {
                    Surface {
                        FeedbackFilterRow(
                            filter = state.filter,
                            myUserData = state.myUserData,
                            onFilterChange = { handleIntent(DemoIntentHandler.UpdateFilter(it)) },
                            showForm = state.showForm,
                            onShowFormChange = { handleIntent(DemoIntentHandler.ShowForm) },
                            modifier = Modifier.padding(bottom = 8.dp),
                        )
                    }
                }

                when {
                    isLoading -> {
                        items(5) { FeedbackItemShimmer() }
                    }

                    state.feedbackList.isEmpty() -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillParentMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                EmptyScreenMessage(
                                    title = "No feedback found",
                                    message = "Try adjusting your filters or check back later.",
                                    icon = Icons.Default.Info,
                                )
                            }
                        }
                    }

                    state.listIsError -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillParentMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                EmptyScreenMessage(
                                    title = "Something went wrong",
                                    message = state.listErrorMessage,
                                    icon = Icons.Default.Info,
                                    actionLabel = "Try again",
                                    onActionClick = { handleIntent(DemoIntentHandler.GetFeedback(state.filter)) },
                                )
                            }
                        }
                    }

                    else -> {
                        items(state.feedbackList) { item ->
                            FeedbackItem(
                                item = item,
                                isPreview = true,
                                onClick = {
                                    item.id?.let { id ->
                                        handleIntent(DemoIntentHandler.GetFeedbackById(id))
                                    }
                                },
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Composable function that displays a row of filter chips for feedback.
 *
 * @param myUserData The current user's data, used to filter by "Just mine".
 * @param filter The current feedback filter.
 * @param showForm Whether the new feedback form is shown.
 * @param onShowFormChange Callback triggered when the "New Feedback" chip is clicked.
 * @param onFilterChange Callback triggered when a filter chip is clicked or a dropdown option is selected.
 * @param modifier Modifier for this composable.
 */
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FeedbackFilterRow(
    myUserData: UserData? = null,
    filter: GetFeedbackFilter,
    showForm: Boolean = false,
    onShowFormChange: () -> Unit = {},
    onFilterChange: (GetFeedbackFilter) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectedFeature = filter.targetType?.let { label ->
        EventFeature.entries.firstOrNull { it.label == label }
    }

    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        // --- Just mine chip ---
        FilterChip(
            selected = filter.userId != null,
            onClick = {
                onFilterChange(
                    filter.copy(userId = if (filter.userId == null) myUserData?.id else null),
                )
            },
            label = { Text("Just mine") },
        )

        FilterDropdownChip(
            label = selectedFeature?.label ?: "Feature",
            selected = selectedFeature != null,
            options = EventFeature.entries.map { it.label to it.label }, // display + return label
            onSelect = { label ->
                onFilterChange(filter.copy(targetType = label)) // store label
            },
            onClear = { onFilterChange(filter.copy(targetType = null)) },
        )

        // --- Status chip ---
        FilterDropdownChip(
            label = filter.status?.name ?: "Status",
            selected = filter.status != null,
            options = FeedbackStatus.entries.map { it.name to it.name },
            onSelect = { name ->
                onFilterChange(filter.copy(status = FeedbackStatus.valueOf(name)))
            },
            onClear = { onFilterChange(filter.copy(status = null)) },
        )

        FilterChip(
            selected = showForm,
            onClick = onShowFormChange,
            label = {
                Text("New Feedback")
            },
        )
    }
}

/**
 * A composable that displays a filter chip with a dropdown menu for selecting options.
 *
 * @param label The text to display on the chip.
 * @param selected Whether the chip is currently selected (an option is chosen).
 * @param options A list of pairs, where each pair represents an option. The first element is the value to be returned when the option is selected, and the second element is the text to display for the option in the dropdown.
 * @param onSelect Callback triggered when an option is selected from the dropdown. It receives the value of the selected option.
 * @param onClear Callback triggered when the "All" option is selected, indicating that the filter should be cleared.
 */
@Composable
private fun FilterDropdownChip(
    label: String,
    selected: Boolean,
    options: List<Pair<String, String>>, // (value, display)
    onSelect: (String) -> Unit,
    onClear: () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    FilterChip(
        selected = selected,
        onClick = { expanded = true },
        label = { Text(label) },
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
    ) {
        DropdownMenuItem(
            text = { Text("All") },
            onClick = {
                onClear()
                expanded = false
            },
        )
        options.forEach { (value, display) ->
            DropdownMenuItem(
                text = { Text(display) },
                onClick = {
                    onSelect(value)
                    expanded = false
                },
            )
        }
    }
}
