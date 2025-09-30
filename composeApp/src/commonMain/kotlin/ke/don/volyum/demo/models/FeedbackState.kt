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
 * Represents the state of the feedback feature, including filters, feedback lists,
 * user data, and states for reading and sending feedback.
 *
 * @property filter The current filter applied to the feedback list.
 * @property feedbackList The list of feedback items.
 * @property listErrorMessage An error message related to fetching the feedback list, if any.
 * @property listIsLoading True if the feedback list is currently being loaded, false otherwise.
 * @property listIsError True if there was an error fetching the feedback list, false otherwise.
 * @property myUserData Data of the currently logged-in user.
 * @property targetType The type of event or feature the feedback is related to.
 * @property sender Specifies whether the feedback is submitted as "My Profile" or "Anonymous".
 * @property showDetails True to show the feedback details view, false otherwise.
 * @property showForm True to show the feedback submission form, false otherwise.
 * @property readFeedback The feedback item currently being viewed in detail.
 * @property readErrorMessage An error message related to reading a specific feedback item, if any.
 * @property readIsLoading True if a specific feedback item is currently being loaded, false otherwise.
 * @property readIsError True if there was an error reading a specific feedback item, false otherwise.
 * @property sendFeedback The feedback item being prepared for submission.
 * @property sendErrorMessage An error message related to sending feedback, if any.
 * @property sendIsLoading True if feedback is currently being sent, false otherwise.
 * @property sendIsError True if there was an error sending feedback, false otherwise.
 */
data class FeedbackState(
    val filter: GetFeedbackFilter = GetFeedbackFilter(limit = 10),
    val feedbackList: List<Feedback> = emptyList(),
    val listErrorMessage: String? = null,
    val listIsLoading: Boolean = true,
    val listIsError: Boolean = false,

    val myUserData: UserData = UserData(
        id = "1",
        name = "Donald",
        profileUrl = "https://picsum.photos/200?seed=1",
    ),
    val targetType: EventFeature = EventFeature.TICKETING,
    val sender: UserSubmitOption = UserSubmitOption.MyProfile,
    val showDetails: Boolean = false,
    val showForm: Boolean = false,

    val readFeedback: Feedback = Feedback(),
    val readErrorMessage: String? = null,
    val readIsLoading: Boolean = true,
    val readIsError: Boolean = false,

    val sendFeedback: Feedback = Feedback(rating = 3),
    val sendErrorMessage: String? = null,
    val sendIsLoading: Boolean = false,
    val sendIsError: Boolean = false,
)
