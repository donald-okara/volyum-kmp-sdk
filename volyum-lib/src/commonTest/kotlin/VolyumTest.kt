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
import io.github.donald_okara.volyum.config.Volyum
import io.github.donald_okara.volyum.config.VolyumConfig
import io.github.donald_okara.volyum.config.VolyumFactory
import io.github.donald_okara.volyum.model.domain.VolyumResult
import io.github.donald_okara.volyum.model.domain.data_transfer.GetFeedbackFilter
import io.github.donald_okara.volyum.model.domain.isSuccess
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class VolyumTest {
    private val config = VolyumConfig("123", "your_api_key")

    @Test
    fun sendFeedbackReturnsSuccess() = runTest {
        // Assign
        val volyum: Volyum = VolyumFactory.createInternal(config, apiClient = FakeApiClient())
        val feedback = fakeFeedbackItem

        // Act
        val result = volyum.sendFeedback(feedback)

        // Assert
        assertTrue(result.isSuccess())
        assertEquals(feedback, (result as VolyumResult.Success).data)
    }

    @Test
    fun sendFeedbackReturnsErrorWhenIdIsInvalid() = runTest {
        // Assign
        val volyum: Volyum = VolyumFactory.createInternal(config, apiClient = FakeApiClient())
        val feedback = fakeFeedbackItem.copy(id = "0")

        // Act
        val result = volyum.sendFeedback(feedback)

        // Assert
        assertTrue(!result.isSuccess())
    }

    @Test
    fun getFeedbackReturnsFeedbackList() = runTest {
        // Assign
        val volyum: Volyum = VolyumFactory.createInternal(config, apiClient = FakeApiClient())
        val userId = "6"

        // Act
        val result = volyum.getFeedback(GetFeedbackFilter(userId = userId))

        // Assert
        assertTrue(result.isSuccess())
        assertEquals(fakeFeedbackList, (result as VolyumResult.Success).data)
    }

    @Test
    fun getFeedbackReturnsErrorWhenUserIdInvalid() = runTest {
        // Assign
        val volyum: Volyum = VolyumFactory.createInternal(config, apiClient = FakeApiClient())

        // Act
        val result = volyum.getFeedback(GetFeedbackFilter(userId = "0"))

        // Assert
        assertTrue(!result.isSuccess())
    }

    @Test
    fun getFeedbackByIdFetchesData() = runTest {
        // Assign
        val volyum: Volyum = VolyumFactory.createInternal(config, apiClient = FakeApiClient())

        // Act
        val result = volyum.getFeedbackById("1")

        // Assert
        assertTrue(result.isSuccess())
        assertEquals(fakeFeedbackItem, (result as VolyumResult.Success).data)
    }

    @Test
    fun getFeedbackByIdReturnsErrorWhenIdIsInvalid() = runTest {
        // Assign
        val volyum: Volyum = VolyumFactory.createInternal(config, apiClient = FakeApiClient())

        // Act
        val result = volyum.getFeedbackById("0")

        // Assert
        assertTrue(!result.isSuccess())
    }
}
