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

import ke.don.volyum.feedback.model.domain.data_transfer.GetFeedbackFilter
import ke.don.volyum.feedback.model.table.Feedback

sealed class DemoIntentHandler {
    data class GetFeedback(
        val filter: GetFeedbackFilter,
    ) : DemoIntentHandler()
    data class GetFeedbackById(
        val id: String,
    ) : DemoIntentHandler()
    data class UpdateFeedback(
        val feedback: Feedback,
    ) : DemoIntentHandler()
    data class UpdateTargetType(
        val targetType: EventFeature,
    ) : DemoIntentHandler()
    data class UpdateSender(
        val sender: UserSubmitOption,
    ) : DemoIntentHandler()
    data class UpdateFilter(
        val filter: GetFeedbackFilter,
    ) : DemoIntentHandler()
    data object SendFeedback : DemoIntentHandler()
    data object ShowDetails : DemoIntentHandler()
    data object ShowForm : DemoIntentHandler()
}
