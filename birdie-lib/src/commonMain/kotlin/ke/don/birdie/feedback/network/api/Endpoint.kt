/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.network.api

import ke.don.birdie.feedback.model.domain.Constants.URL

internal sealed class Endpoint(val route: String) {
    open val baseUrl = "$URL/rest/v1/"

    val url: String
        get() = buildString {
            append(baseUrl)
            append(route)
        }

    sealed class Functions(route: String) : Endpoint(route) {
        override val baseUrl = "$URL/functions/v1/"

        object AddFeedback : Functions(route = "submit_feedback")
        object GetFeedback : Functions(route = "get_feedback")
        object GetFeedbackById : Functions(route = "get_feedback_by_id")
    }
}
