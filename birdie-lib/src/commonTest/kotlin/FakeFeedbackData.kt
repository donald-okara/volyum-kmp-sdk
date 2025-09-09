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
        )
    )

    val fakeFeedbackItem = Feedback(
        id = "1",
        userId = "user123",
        targetId = "feature213",
        targetType = "feature",
        text = "This is a comment",
    )
}