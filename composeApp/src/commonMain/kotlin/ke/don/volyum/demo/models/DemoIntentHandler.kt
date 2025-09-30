/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.models

import io.github.donald_okara.volyum.model.domain.data_transfer.GetFeedbackFilter
import io.github.donald_okara.volyum.model.table.Feedback

/**
 * Represents the different intents or actions that can be performed in the demo application.
 * These intents are used to communicate user actions or system events to the appropriate handlers.
 */
sealed class DemoIntentHandler {
    /**
     * Represents an intent to get feedback based on a filter.
     *
     * @property filter The filter to apply when fetching feedback.
     */
    data class GetFeedback(
        val filter: GetFeedbackFilter,
    ) : DemoIntentHandler()

    /**
     * Represents an intent to retrieve a specific feedback entry by its unique identifier.
     *
     * @property id The unique identifier of the feedback to retrieve.
     */
    data class GetFeedbackById(
        val id: String,
    ) : DemoIntentHandler()

    /**
     * Represents an intent to update an existing feedback.
     *
     * @property feedback The [Feedback] object containing the updated information.
     */
    data class UpdateFeedback(
        val feedback: Feedback,
    ) : DemoIntentHandler()

    /**
     * Represents an intent to update the target type for feedback.
     *
     * @property targetType The new target type to set.
     */
    data class UpdateTargetType(
        val targetType: EventFeature,
    ) : DemoIntentHandler()

    /**
     * Represents an intent to update the sender of the feedback.
     *
     * @property sender The new sender option to be set.
     */
    data class UpdateSender(
        val sender: UserSubmitOption,
    ) : DemoIntentHandler()

    /**
     * Represents an intent to update the feedback filter.
     *
     * @property filter The new filter to be applied.
     */
    data class UpdateFilter(
        val filter: GetFeedbackFilter,
    ) : DemoIntentHandler()

    /**
     * Represents an intent to send feedback.
     * This intent handler is responsible for triggering the feedback sending process.
     */
    data object SendFeedback : DemoIntentHandler()

    /**
     * Intent to show the details screen.
     */
    data object ShowDetails : DemoIntentHandler()

    /**
     * An intent handler that signals the UI to show the feedback form.
     */
    data object ShowForm : DemoIntentHandler()
}
