/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.config

import io.github.donald_okara.volyum.model.domain.ProjectIdentity

/**
 * Configuration class for Volyum.
 *
 * This data class holds the necessary credentials to interact with the Volyum API.
 *
 * @property projectId The unique identifier for your Volyum project.
 * @property apiKey The API key associated with your Volyum project for authentication.
 */
data class VolyumConfig(
    val projectId: String,
    val apiKey: String,
) {
    fun toProjectIdentifier(): ProjectIdentity {
        require(projectId.isNotBlank()) { "projectId must not be blank" }
        require(apiKey.isNotBlank()) { "apiKey must not be blank" }
        return ProjectIdentity(
            id = projectId,
            key = apiKey,
        )
    }
}
