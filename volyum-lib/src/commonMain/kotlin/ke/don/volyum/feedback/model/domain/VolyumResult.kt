/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.feedback.model.domain

sealed interface VolyumResult<out D, out E : VolyumError> {
    data class Success<out D>(val data: D) : VolyumResult<D, Nothing>
    data class Error<out E : ke.don.volyum.feedback.model.domain.VolyumError>(val error: E) : VolyumResult<Nothing, E>
}

inline fun <T, E : VolyumError, R> VolyumResult<T, E>.map(map: (T) -> R): VolyumResult<R, E> {
    return when (this) {
        is VolyumResult.Error -> VolyumResult.Error(error)
        is VolyumResult.Success -> VolyumResult.Success(map(data))
    }
}

fun <T, E : VolyumError> VolyumResult<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map { }
}

inline fun <T, E : VolyumError> VolyumResult<T, E>.onSuccess(action: (T) -> Unit): VolyumResult<T, E> {
    return when (this) {
        is VolyumResult.Error -> this
        is VolyumResult.Success -> {
            action(data)
            this
        }
    }
}
inline fun <T, E : VolyumError> VolyumResult<T, E>.onError(action: (E) -> Unit): VolyumResult<T, E> {
    return when (this) {
        is VolyumResult.Error -> {
            action(error)
            this
        }
        is VolyumResult.Success -> this
    }
}

fun VolyumResult<*, *>.isSuccess(): Boolean {
    return when (this) {
        is VolyumResult.Error<*> -> false
        is VolyumResult.Success<*> -> true
    }
}

typealias EmptyResult<E> = VolyumResult<Unit, E>
