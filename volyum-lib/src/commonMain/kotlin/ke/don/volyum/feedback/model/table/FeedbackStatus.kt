/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.model.table

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the status of a feedback item.
 *
 * This enum class is used to track the progress of a feedback item through its lifecycle.
 * The possible statuses are:
 *
 * * **Pending**: The feedback item has been submitted but not yet reviewed.
 * * **Reviewed**: The feedback item has been reviewed by an administrator.
 * * **Resolved**: The feedback item has been addressed and the issue is considered resolved.
 * * **Rejected**: The feedback item has been reviewed and rejected.
 * * **Unknown**: The fallback status for unknown or invalid values.
 */
@Serializable
enum class FeedbackStatus {
    Unknown,

    @SerialName("pending")
    Pending,

    @SerialName("reviewed")
    Reviewed,

    @SerialName("resolved")
    Resolved,

    @SerialName("rejected")
    Rejected,
}
