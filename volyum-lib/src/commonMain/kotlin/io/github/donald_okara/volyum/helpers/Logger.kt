/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.donald_okara.volyum.helpers

import co.touchlab.kermit.Logger

/**
 * Creates a [Logger] instance with a tag derived from the reified type `T`.
 *
 * If the simple name of the class `T` is available, it's used as the tag.
 * Otherwise, the default tag "Volyum" is used.
 *
 * This is an inline function, which means the bytecode of this function will be
 * copied into the call site, potentially improving performance by avoiding
 * function call overhead. The `reified` keyword allows accessing the type `T`
 * at runtime.
 *
 * @return A [Logger] instance configured with an appropriate tag.
 */
internal inline fun <reified T> logger(): Logger {
    return Logger.withTag(T::class.simpleName ?: "Volyum")
}
