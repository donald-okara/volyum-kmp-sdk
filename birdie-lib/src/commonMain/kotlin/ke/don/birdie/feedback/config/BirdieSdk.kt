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

import kotlin.concurrent.Volatile

object BirdieSdk {
    @Volatile
    private var instance: Birdie? = null

    fun init(config: BirdieConfig) {
        check(instance == null) { "BirdieSdk is already initialized" }
        instance = BirdieFactory.create(config)
    }

    fun get(): Birdie =
        instance ?: error("BirdieSdk not initialized. Call BirdieSdk.init(config) first.")
}
