/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.model.domain

/**
 * Represents the identity of a project.
 *
 * @property id The unique identifier of the project.
 * @property key The key associated with the project, often used for API authentication or identification.
 */
data class ProjectIdentity(
    val id: String,
    val key: String,
)
