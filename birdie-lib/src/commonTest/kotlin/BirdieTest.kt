/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
import FakeFeedbackData.fakeFeedbackItem
import FakeFeedbackData.fakeFeedbackList
import ke.don.birdie.feedback.config.Birdie
import ke.don.birdie.feedback.config.BirdieConfig
import ke.don.birdie.feedback.config.BirdieFactory
import ke.don.birdie.feedback.model.domain.BirdieResult
import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.birdie.feedback.model.domain.isSuccess
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BirdieTest {
    private val config = BirdieConfig("123", "your_api_key")

    @Test
    fun sendFeedbackReturnsSuccess() = runTest {
        // Assign
        val birdie: Birdie = BirdieFactory.createInternal(config, apiClient = FakeApiClient())
        val feedback = fakeFeedbackItem

        // Act
        val result = birdie.sendFeedback(feedback)

        // Assert
        assertTrue(result.isSuccess())
        assertEquals(feedback, (result as BirdieResult.Success).data)
    }

    @Test
    fun sendFeedbackReturnsErrorWhenIdIsInvalid() = runTest {
        // Assign
        val birdie: Birdie = BirdieFactory.createInternal(config, apiClient = FakeApiClient())
        val feedback = fakeFeedbackItem.copy(id = "0")

        // Act
        val result = birdie.sendFeedback(feedback)

        // Assert
        assertTrue(!result.isSuccess())
    }

    @Test
    fun getFeedbackReturnsFeedbackList() = runTest {
        // Assign
        val birdie: Birdie = BirdieFactory.createInternal(config, apiClient = FakeApiClient())
        val userId = "6"

        // Act
        val result = birdie.getFeedback(GetFeedbackFilter(userId = userId))

        // Assert
        assertTrue(result.isSuccess())
        assertEquals(fakeFeedbackList, (result as BirdieResult.Success).data)
    }

    @Test
    fun getFeedbackReturnsErrorWhenUserIdInvalid() = runTest {
        // Assign
        val birdie: Birdie = BirdieFactory.createInternal(config, apiClient = FakeApiClient())

        // Act
        val result = birdie.getFeedback(GetFeedbackFilter(userId = "0"))

        // Assert
        assertTrue(!result.isSuccess())
    }

    @Test
    fun getFeedbackByIdFetchesData() = runTest {
        // Assign
        val birdie: Birdie = BirdieFactory.createInternal(config, apiClient = FakeApiClient())

        // Act
        val result = birdie.getFeedbackById("1")

        // Assert
        assertTrue(result.isSuccess())
        assertEquals(fakeFeedbackItem, (result as BirdieResult.Success).data)
    }

    @Test
    fun getFeedbackByIdReturnsErrorWhenIdIsInvalid() = runTest {
        // Assign
        val birdie: Birdie = BirdieFactory.createInternal(config, apiClient = FakeApiClient())

        // Act
        val result = birdie.getFeedbackById("0")

        // Assert
        assertTrue(!result.isSuccess())
    }
}
