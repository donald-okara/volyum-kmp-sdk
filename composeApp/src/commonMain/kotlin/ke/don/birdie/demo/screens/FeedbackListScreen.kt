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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ke.don.birdie.demo.FeedbackState
import ke.don.birdie.demo.components.FeedbackItem
import ke.don.birdie.demo.models.DemoIntentHandler

@Composable
fun FeedbackList(
    modifier: Modifier = Modifier,
    state: FeedbackState,
    handleIntent: (DemoIntentHandler) -> Unit,
) {
    Surface(
        modifier = Modifier
            .widthIn(max = 420.dp), // phone-like width
    ) {
        if (state.listIsLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn(
                modifier = Modifier,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(state.feedbackList) {
                    FeedbackItem(
                        item = it,
                        isPreview = true,
                        onClick = {
                            handleIntent(DemoIntentHandler.GetFeedbackById(it.id!!))
                        },
                    )
                }
            }
        }
    }
}
