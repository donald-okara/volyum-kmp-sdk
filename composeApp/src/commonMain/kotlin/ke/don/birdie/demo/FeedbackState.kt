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

import ke.don.birdie.demo.models.EventFeature
import ke.don.birdie.demo.models.UserData
import ke.don.birdie.demo.models.UserSubmitOption
import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.birdie.feedback.model.table.Feedback

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
