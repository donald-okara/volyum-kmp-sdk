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

import kotlinx.atomicfu.atomic

object BirdieSdk {
    private val instanceRef = atomic<Birdie?>(null)

    fun init(config: BirdieConfig) {
        val created = BirdieFactory.create(config)
        if (!instanceRef.compareAndSet(null, created)) {
            error("BirdieSdk is already initialized")
        }
    }

    fun get(): Birdie =
        instanceRef.value ?: error("BirdieSdk not initialized. Call BirdieSdk.init(config) first.")
}
