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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import birdiesdk.composeapp.generated.resources.Res
import birdiesdk.composeapp.generated.resources.compose_multiplatform
import ke.don.birdie.feedback.model.domain.NetworkError
import ke.don.birdie.feedback.model.domain.ProjectIdentity
import ke.don.birdie.feedback.model.domain.TestData
import ke.don.birdie.feedback.model.domain.onError
import ke.don.birdie.feedback.model.domain.onSuccess
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.network.api.BirdieApi
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val coroutineScope = rememberCoroutineScope()
        var showContent by remember { mutableStateOf(false) }

        var testData by remember {
            mutableStateOf(emptyList<TestData>())
        }
        var feedback by remember {
            mutableStateOf(emptyList<String>())
        }
        var errorMessage by remember {
            mutableStateOf<NetworkError?>(null)
        }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                showContent = !showContent
                coroutineScope.launch {
                    BirdieApi.fetchTestData()
                        .onSuccess {
                            testData = it
                        }
                        .onError {
                            errorMessage = it
                        }
                }

            }) {
                Text("Click me!")
            }

            Button(onClick = {
                coroutineScope.launch {
                    BirdieApi.addFeedback(
                        projectIdentity = ProjectIdentity(
                            id = "df35f8db-bbe6-40f1-993f-8335e2a22eda",
                            key = "00=="
                        ),
                        feedback = Feedback(
                            rating = 5,
                            userId = "user123",
                            targetId = "feature213",
                            targetType = "feature",
                            text =  "This is a comment"
                        )
                    )
                        .onSuccess {
                            feedback = feedback + it.toString()
                        }
                        .onError {
                            errorMessage = it
                        }
                }

            }) {
                Text("Click me!")
            }

            feedback.forEach {
                Text(it)
            }
            testData.forEach {
                it.text?.let { text -> Text(text) }
            }
            errorMessage?.let {
                Text(it.category.name)
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
