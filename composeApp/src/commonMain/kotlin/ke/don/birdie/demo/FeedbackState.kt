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

import ke.don.birdie.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.birdie.feedback.model.table.Feedback

data class FeedbackState(
    val filter: GetFeedbackFilter = GetFeedbackFilter(limit = 10),
    val feedbackList: List<Feedback> = emptyList(),
    val listErrorMessage: String? = null,
    val listIsLoading: Boolean = false,
    val listIsError: Boolean = false,

    val readFeedback: Feedback = Feedback(),
    val readErrorMessage: String? = null,
    val readIsLoading: Boolean = false,
    val readIsError: Boolean = false,

    val sendFeedback: Feedback = Feedback(),
    val sendErrorMessage: String? = null,
    val sendIsLoading: Boolean = false,
    val sendIsError: Boolean = false,
)
