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
 * Represents a network error that occurred during an operation.
 *
 * This class encapsulates details about a network error, providing information
 * about its category, a descriptive message, and an optional error code.
 * It inherits from [VolyumError], making it part of a common error handling framework.
 *
 * @property category The category of the network error, defaulting to [NetworkErrorCategory.UNKNOWN].
 *                    This helps in classifying the type of network issue (e.g., connection timeout, server error).
 * @property message A human-readable message describing the network error. This can be null if no specific message is available.
 * @property code An optional integer code associated with the network error (e.g., HTTP status code). This can be null.
 */
data class NetworkError(
    val category: NetworkErrorCategory = NetworkErrorCategory.UNKNOWN,
    val message: String? = null,
    val code: Int? = null,
) : VolyumError
