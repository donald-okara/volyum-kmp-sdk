/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.config

import kotlinx.atomicfu.atomic

object VolyumSdk {
    private val instanceRef = atomic<Volyum?>(null)

    fun init(config: VoyumConfig) {
        val created = VolyumFactory.create(config)
        if (!instanceRef.compareAndSet(null, created)) {
            error("VolyumSdk is already initialized")
        }
    }

    fun get(): Volyum =
        instanceRef.value ?: error("VolyumSdk not initialized. Call VolyumSdk.init(config) first.")
}
