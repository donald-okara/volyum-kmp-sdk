/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.network.api

import ke.don.volyum.feedback.model.domain.Constants.URL

/**
 * Represents the various API endpoints used for network communication.
 * This sealed class provides a structured way to define and access different API routes.
 *
 * @property route The specific path for the endpoint, appended to the [baseUrl].
 */
internal sealed class Endpoint(val route: String) {
    /**
     * The base URL for the API endpoint.
     */
    open val baseUrl = "$URL/rest/v1/"

    /**
     * The complete URL for the endpoint, constructed by appending the [route] to the [baseUrl].
     */
    val url: String
        get() = buildString {
            append(baseUrl)
            append(route)
        }

    /**
     * Represents the available functions endpoints for the feedback API.
     *
     * This sealed class defines the specific routes for interacting with feedback-related functions.
     * Each object within this class corresponds to a particular function endpoint.
     */
    sealed class Functions(route: String) : Endpoint(route) {
        override val baseUrl = "$URL/functions/v1/"

        /**
         * Represents the endpoint for submitting feedback.
         */
        object AddFeedback : Functions(route = "submit_feedback")

        /**
         * Represents the endpoint for retrieving feedback.
         */
        object GetFeedback : Functions(route = "get_feedback")

        /**
         * Represents the endpoint for retrieving a specific feedback entry by its ID.
         * The complete URL for this endpoint will be constructed by combining the base functions URL
         * (e.g., "https://your-domain.com/functions/v1/") with the route "get_feedback_by_id".
         */
        object GetFeedbackById : Functions(route = "get_feedback_by_id")
    }
}
