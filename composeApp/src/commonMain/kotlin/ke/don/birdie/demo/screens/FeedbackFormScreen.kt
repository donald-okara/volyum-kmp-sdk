/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.demo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.StarRate
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import ke.don.birdie.demo.FeedbackState
import ke.don.birdie.demo.components.RatingInput
import ke.don.birdie.demo.components.StarSurface
import ke.don.birdie.demo.models.DemoIntentHandler
import ke.don.birdie.demo.models.EventFeature
import ke.don.birdie.demo.models.UserSubmitOption

@Composable
fun FeedbackForm(
    modifier: Modifier = Modifier,
    state: FeedbackState,
    onEvent: (DemoIntentHandler) -> Unit,
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .fillMaxHeight()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Header
                FormHeader()

                // Rating section
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    LabelText(text = "Your Rating")
                    RatingInput(
                        rating = state.sendFeedback.rating ?: 3,
                        onRatingChange = {
                            onEvent(
                                DemoIntentHandler.UpdateFeedback(
                                    state.sendFeedback.copy(rating = it)
                                )
                            )
                        }
                    )
                }

                // Feature dropdown
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    LabelText(text = "Product Feature")
                    FeatureDropdown(
                        selected = state.targetType,
                        onFeatureSelected = {
                            onEvent(DemoIntentHandler.UpdateTargetType(it))
                        }
                    )
                }

                // Feedback text area
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    LabelText(text = "Product Review")
                    FeedbackTextField(
                        text = state.sendFeedback.text ?: "",
                        onTextChange = {
                            onEvent(
                                DemoIntentHandler.UpdateFeedback(
                                    state.sendFeedback.copy(text = it)
                                )
                            )
                        }
                    )
                }

                // Submit option
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    LabelText(text = "Who are we sending as?")
                    UserSubmitOptionSelector(
                        selected = state.sender,
                        onOptionSelected = {
                            onEvent(DemoIntentHandler.UpdateSender(it))
                        }
                    )
                }

                // Spacer pushes submit button to bottom
                Spacer(modifier = Modifier.weight(1f))

                // Submit button
                Button(
                    enabled = !state.sendIsLoading,
                    onClick = { onEvent(DemoIntentHandler.SendFeedback) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    if (state.sendIsLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text("Submit Feedback")
                    }
                }
            }

            // Dismiss "X" button
            IconButton(
                onClick = { onEvent(DemoIntentHandler.ShowForm) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Dismiss"
                )
            }
        }
    }
}


@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun UserSubmitOptionSelector(
    modifier: Modifier = Modifier,
    selected: UserSubmitOption,
    onOptionSelected: (UserSubmitOption) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        UserSubmitOption.entries.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = option == selected,
                        onClick = { onOptionSelected(option) },
                        role = Role.RadioButton
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = option == selected,
                    onClick = { onOptionSelected(option) }
                )

                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = option.name,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = if (option == selected) FontWeight.SemiBold else FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = option.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}


@Composable
fun FormHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            StarSurface(
                onClick = {},
                filled = true,
                size = 48.dp
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Rate this product",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Provide feedback for the product",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(8.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    minLines: Int = 5,
    maxChars: Int = 500
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.length <= maxChars) onTextChange(it)
            },
            placeholder = { Text("Write your feedback here...") },
            label = { Text("Your Feedback") },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 150.dp), // makes it taller by default
            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = false,
            minLines = minLines
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Character counter
        Text(
            text = "${text.length} / $maxChars",
            style = MaterialTheme.typography.bodySmall,
            color = if (text.length >= maxChars)
                MaterialTheme.colorScheme.error
            else
                MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.align(Alignment.End)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureDropdown(
    modifier: Modifier = Modifier,
    selected: EventFeature,
    onFeatureSelected: (EventFeature) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        // Anchor
        OutlinedTextField(
            value = selected.label,
            onValueChange = {},
            readOnly = true,
            label = { Text("Select a feature") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        // Dropdown menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            EventFeature.entries.forEach { feature ->
                DropdownMenuItem(
                    text = { Text(feature.label) },
                    onClick = {
                        onFeatureSelected(feature)
                        expanded = false
                    }
                )
            }
        }
    }
}

