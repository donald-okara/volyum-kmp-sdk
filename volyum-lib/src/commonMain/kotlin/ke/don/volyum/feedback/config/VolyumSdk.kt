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

/**
 * The entry point for the Volyum SDK.
 *
 * This object provides methods to initialize and access the Volyum instance.
 * It ensures that the SDK is initialized only once and provides a convenient way to get the
 * initialized Volyum instance.
 *
 * Example usage:
 * ```kotlin
 * // Initialize the SDK with a configuration
 * VolyumSdk.init(VolyumConfig(...))
 *
 * // Get the Volyum instance
 * val volyum = VolyumSdk.get()
 *
 * // Use the Volyum instance
 * volyum.someMethod()
 * ```
 */
object VolyumSdk {
    /**
     * Holds an atomic reference to the Volyum instance.
     * This ensures thread-safe initialization and access to the singleton instance.
     * It is initialized to null and set only once during the `init` call.
     */
    private val instanceRef = atomic<Volyum?>(null)

    /**
     * Initializes the VolyumSdk with the provided configuration.
     *
     * This function should be called only once during the application's lifecycle, typically in the
     * Application class's `onCreate` method.
     *
     * @param config The [VolyumConfig] object containing the settings for the SDK.
     * @throws IllegalStateException if the SDK has already been initialized.
     */
    fun init(config: VolyumConfig) {
        val created = VolyumFactory.create(config)
        if (!instanceRef.compareAndSet(null, created)) {
            error("VolyumSdk is already initialized")
        }
    }

    /**
     * Retrieves the initialized Volyum instance.
     *
     * @return The Volyum instance.
     * @throws IllegalStateException if VolyumSdk has not been initialized by calling [init] first.
     */
    fun get(): Volyum =
        instanceRef.value ?: error("VolyumSdk not initialized. Call VolyumSdk.init(config) first.")
}
