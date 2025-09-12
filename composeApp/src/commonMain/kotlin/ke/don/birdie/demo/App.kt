/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import ke.don.birdie.demo.models.DemoIntentHandler
import ke.don.birdie.demo.models.FeedbackViewModel
import ke.don.birdie.demo.models.WindowSizeClass
import ke.don.birdie.demo.models.getScreenWidth
import ke.don.birdie.demo.models.getWindowSizeClass
import ke.don.birdie.demo.screens.FeedbackDetailsScreen
import ke.don.birdie.demo.screens.FeedbackForm
import ke.don.birdie.demo.screens.FeedbackList
import ke.don.birdie.demo.theme.BirdieTheme
import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.koffee.annotations.ExperimentalKoffeeApi
import ke.don.koffee.model.KoffeeDefaults
import ke.don.koffee.ui.KoffeeBar
import ke.don.koffee.ui.toasts_suite.GlowingToast
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalKoffeeApi::class)
@Composable
@Preview
fun App() {
    BirdieTheme {
        val viewModel: FeedbackViewModel = viewModel()
        val state by viewModel.uiState.collectAsState()
        val handleIntent = viewModel::handleIntent

        val koffeeConfig = KoffeeDefaults.config.copy(
            layout = { GlowingToast(it) },
            maxVisibleToasts = 3,
        )
        LaunchedEffect(viewModel) {
            handleIntent(DemoIntentHandler.GetFeedback(GetFeedbackFilter()))
        }

        Surface {
            KoffeeBar(
                config = koffeeConfig,
            ) {
                FeedbackScreenContent(
                    state = state,
                    handleIntent = handleIntent,
                )
            }
        }
    }
}

// --- Top-level screen switcher ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreenContent(
    state: FeedbackState,
    handleIntent: (DemoIntentHandler) -> Unit,
) {
    val screenWidth = getScreenWidth().toInt().dp
    val windowSize = getWindowSizeClass(screenWidth)

    when (windowSize) {
        WindowSizeClass.Compact -> {
            MobileScreen(state, handleIntent)
        }
        WindowSizeClass.Medium -> {
            ResponsiveScaffold(
                state = state,
                handleIntent = handleIntent,
                padding = 24.dp,
                detailsWeight = 2f,
                formWeight = 1f,
                listWeight = 1f,
                detailsOffset = { it }, // slide from right
            )
        }
        WindowSizeClass.Expanded -> {
            ResponsiveScaffold(
                state = state,
                handleIntent = handleIntent,
                padding = 32.dp,
                listWeight = 2f,
                formWeight = 1f,
                detailsWeight = 1f,
                detailsOffset = { -it }, // slide from left
            )
        }
    }
}

@Composable
private fun ResponsiveScaffold(
    state: FeedbackState,
    handleIntent: (DemoIntentHandler) -> Unit,
    padding: Dp,
    listWeight: Float = 1f,
    formWeight: Float = 1f,
    detailsWeight: Float = 1f,
    detailsOffset: (Int) -> Int,
) {
    val baseWidth = 420.dp
    val expandedWidth = 600.dp
    val minPanelWidth = 420.dp

    val listWidth by animateDpAsState(
        targetValue = if (state.showForm || state.showDetails) baseWidth else expandedWidth,
        animationSpec = tween(300),
        label = "listWidthAnim",
    )

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
    ) {
        val totalWidth = maxWidth

        // --- Decide modes upfront ---
        val showDialogDetails = state.showDetails && totalWidth < (listWidth + minPanelWidth)
        val showInlineDetails = state.showDetails && !showDialogDetails

        val showDialogForm = state.showForm && totalWidth < (listWidth + minPanelWidth * 2)
        val showInlineForm = state.showForm && !showDialogForm

        LookaheadScope {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            ) {
                // --- List panel ---
                FeedbackList(
                    state = state,
                    handleIntent = handleIntent,
                    modifier = Modifier
                        .widthIn(max = listWidth, min = 420.dp)
                        .weight(listWeight),
                )

                // --- Inline details ---
                if (showInlineDetails) {
                    AnimatedVisibility(
                        visible = true,
                        enter = slideInHorizontally { it } + fadeIn(),
                        exit = slideOutHorizontally { it } + fadeOut(),
                    ) {
                        FeedbackDetailsScreen(
                            state = state,
                            handleIntent = handleIntent,
                            modifier = Modifier
                                .widthIn(max = minPanelWidth, min = 420.dp)
                                .weight(detailsWeight),
                        )
                    }
                }

                // --- Inline form ---
                if (showInlineForm) {
                    AnimatedVisibility(
                        visible = true,
                        enter = slideInHorizontally { fullWidth -> detailsOffset(fullWidth) } + fadeIn(),
                        exit = slideOutHorizontally { fullWidth -> detailsOffset(fullWidth) } + fadeOut(),
                    ) {
                        FeedbackForm(
                            state = state,
                            onEvent = handleIntent,
                            modifier = Modifier
                                .widthIn(max = minPanelWidth, min = 420.dp)
                                .weight(formWeight),
                        )
                    }
                }
            }
        }

        // --- Dialog fallback for Details ---
        if (showDialogDetails) {
            Dialog(
                onDismissRequest = { handleIntent(DemoIntentHandler.ShowDetails) },
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    FeedbackDetailsScreen(
                        state = state,
                        handleIntent = handleIntent,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }

        // --- Dialog fallback for Form ---
        if (showDialogForm) {
            Dialog(
                onDismissRequest = { handleIntent(DemoIntentHandler.ShowForm) },
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    FeedbackForm(
                        state = state,
                        onEvent = handleIntent,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileScreen(
    state: FeedbackState,
    handleIntent: (DemoIntentHandler) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        FeedbackList(
            state = state,
            handleIntent = handleIntent,
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(min = 420.dp), // phone-like width
        )

        if (state.showDetails) {
            ModalBottomSheet(
                containerColor = MaterialTheme.colorScheme.surface,
                onDismissRequest = { handleIntent(DemoIntentHandler.ShowDetails) },
            ) {
                FeedbackDetailsScreen(
                    state = state,
                    handleIntent = handleIntent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(min = 420.dp), // phone-like width
                )
            }
        }

        if (state.showForm) {
            ModalBottomSheet(
                containerColor = MaterialTheme.colorScheme.surface,
                onDismissRequest = { handleIntent(DemoIntentHandler.ShowForm) },
            ) {
                FeedbackForm(
                    state = state,
                    onEvent = handleIntent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(min = 420.dp), // phone-like width
                )
            }
        }
    }
}

@Composable
private fun ToggleControls(
    showDetails: Boolean,
    onToggleDetails: () -> Unit,
    showForm: Boolean,
    onToggleForm: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End),
    ) {
        Button(onClick = onToggleDetails) {
            Text(if (showDetails) "Hide Details" else "Show Details")
        }
        Button(onClick = onToggleForm) {
            Text(if (showForm) "Hide Form" else "Show Form")
        }
    }
}
