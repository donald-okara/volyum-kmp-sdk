/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo

import ke.don.volyum.feedback.config.VolyumConfig

/**
 * Object holding Volyum configuration credentials.
 * This object is typically used to store and provide access to the project ID and API key
 * required for interacting with the Volyum service.
 *
 * The credentials are usually sourced from build configuration, such as `BuildKonfig`.
 */
object VolyumCredentials {
    val CONFIG = VolyumConfig(
        projectId = BuildKonfig.VOLYUM_PROJECT_ID,
        apiKey = BuildKonfig.VOLYUM_API_KEY,
    )
}
