/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.model.domain

sealed interface BirdieResult<out D, out E : BirdieError> {
    data class Success<out D>(val data: D) : BirdieResult<D, Nothing>
    data class Error<out E : ke.don.birdie.feedback.model.domain.BirdieError>(val error: E) : BirdieResult<Nothing, E>
}

inline fun <T, E : BirdieError, R> BirdieResult<T, E>.map(map: (T) -> R): BirdieResult<R, E> {
    return when (this) {
        is BirdieResult.Error -> BirdieResult.Error(error)
        is BirdieResult.Success -> BirdieResult.Success(map(data))
    }
}

fun <T, E : BirdieError> BirdieResult<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map { }
}

inline fun <T, E : BirdieError> BirdieResult<T, E>.onSuccess(action: (T) -> Unit): BirdieResult<T, E> {
    return when (this) {
        is BirdieResult.Error -> this
        is BirdieResult.Success -> {
            action(data)
            this
        }
    }
}
inline fun <T, E : BirdieError> BirdieResult<T, E>.onError(action: (E) -> Unit): BirdieResult<T, E> {
    return when (this) {
        is BirdieResult.Error -> {
            action(error)
            this
        }
        is BirdieResult.Success -> this
    }
}

fun BirdieResult<*, *>.isSuccess(): Boolean {
    return when (this) {
        is BirdieResult.Error<*> -> false
        is BirdieResult.Success<*> -> true
    }
}


typealias EmptyResult<E> = BirdieResult<Unit, E>
