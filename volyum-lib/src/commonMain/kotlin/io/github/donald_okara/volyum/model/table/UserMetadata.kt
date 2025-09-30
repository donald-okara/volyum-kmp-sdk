/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.model.table

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents metadata associated with a user, such as their username and profile URL.
 * This class is serializable, allowing it to be easily converted to and from formats like JSON.
 *
 * @property username The username of the user. This can be null if not available.
 * @property profileUrl The URL of the user's profile picture. This can be null if not available.
 *                      The `@SerialName("profile_url")` annotation indicates that when serialized,
 *                      this property will be represented by the key "profile_url".
 */
@Serializable
data class UserMetadata(
    val username: String? = null,
    @SerialName("profile_url")val profileUrl: String? = null,
)
