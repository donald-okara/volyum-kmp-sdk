/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.config

import ke.don.birdie.feedback.model.domain.ProjectIdentity

data class BirdieConfig(
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
