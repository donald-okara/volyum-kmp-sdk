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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ke.don.birdie.demo.models.DemoIntentHandler
import ke.don.birdie.demo.models.FeedbackViewModel
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
        val handleIntent = viewModel::handleIndent

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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp), // outer breathing space
                    contentAlignment = Alignment.Center,
                ) {
                    FeedbackList(
                        state = state,
                        handleIntent = handleIntent,
                    )
                }
            }
        }
    }
}
