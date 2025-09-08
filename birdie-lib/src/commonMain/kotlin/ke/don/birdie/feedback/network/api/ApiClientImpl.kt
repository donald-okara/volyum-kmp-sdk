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

import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ke.don.birdie.feedback.helpers.EntityUUID
import ke.don.birdie.feedback.model.domain.AddFeedbackRequest
import ke.don.birdie.feedback.model.domain.BirdieResult
import ke.don.birdie.feedback.model.domain.NetworkError
import ke.don.birdie.feedback.model.domain.ProjectIdentity
import ke.don.birdie.feedback.model.domain.map
import ke.don.birdie.feedback.model.table.Feedback
import ke.don.birdie.feedback.network.KtorClientProvider.client
import ke.don.birdie.feedback.network.klient

internal class ApiClientImpl(
    private val projectIdentity: ProjectIdentity,
) : ApiClient {
    override suspend fun addFeedback(
        feedback: Feedback,
    ): BirdieResult<Feedback, NetworkError> = klient<Feedback> {
        client.post(Endpoint.Functions.AddFeedback.url) {
            contentType(ContentType.Application.Json)
            setBody(
                AddFeedbackRequest(
                    projectId = projectIdentity.id,
                    key = projectIdentity.key,
                    feedback = feedback,
                ),
            )
        }
    }
}
