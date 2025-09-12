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

object VolyumCredentials {
    val CONFIG = VolyumConfig(
        projectId = BuildKonfig.VOLYUM_PROJECT_ID,
        apiKey = BuildKonfig.VOLYUM_API_KEY,
    )
}
