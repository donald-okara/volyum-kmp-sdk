/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
import ke.don.birdie.feedback.model.table.Feedback

internal object FakeFeedbackData {
    val fakeFeedbackList = listOf(
        Feedback(
            id = "1",
            userId = "user123",
            targetId = "feature213",
            targetType = "feature",
            text = "This is a comment",
        ),
        Feedback(
            id = "2",
            userId = "user123",
            targetId = "feature213",
            targetType = "feature",
            text = "This is another comment",
        ),
        Feedback(
            id = "3",
            userId = "user123",
            targetId = "feature213",
            targetType = "feature",
            text = "This is a third comment",
        ),
    )

    val fakeFeedbackItem = Feedback(
        id = "1",
        userId = "user123",
        targetId = "feature213",
        targetType = "feature",
        text = "This is a comment",
    )
}
