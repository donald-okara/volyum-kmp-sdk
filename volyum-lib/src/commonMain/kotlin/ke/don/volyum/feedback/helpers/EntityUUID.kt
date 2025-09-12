/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.helpers

import kotlin.jvm.JvmInline

@JvmInline
value class EntityUUID(val value: String) {
    init {
        require(value.matches(Regex("^[0-9a-fA-F-]{36}\$"))) {
            "Invalid UUID format: $value"
        }
    }

    override fun toString(): String = value
}
