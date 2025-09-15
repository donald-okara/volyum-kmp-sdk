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

/**
 * A sealed interface representing the result of an operation that can either be successful or result in an error.
 *
 * This is commonly used in scenarios where an operation might fail, and you need to handle both success and error cases.
 *
 * @param D The type of data expected in a successful result.
 * @param E The type of error expected in an error result, constrained to be a subtype of [VolyumError].
 */
sealed interface VolyumResult<out D, out E : VolyumError> {
    data class Success<out D>(val data: D) : VolyumResult<D, Nothing>
    data class Error<out E : VolyumError>(val error: E) : VolyumResult<Nothing, E>
}

/**
 * Transforms the successful result's data using the provided `map` function.
 * If the result is an error, it returns the original error.
 *
 * @param map A function to apply to the successful result's data.
 * @return A new [VolyumResult] with the transformed data if successful, or the original error if not.
 * @param T The type of the original successful data.
 * @param E The type of the error, which must extend [VolyumError].
 * @param R The type of the transformed successful data.
 */
inline fun <T, E : VolyumError, R> VolyumResult<T, E>.map(map: (T) -> R): VolyumResult<R, E> {
    return when (this) {
        is VolyumResult.Error -> VolyumResult.Error(error)
        is VolyumResult.Success -> VolyumResult.Success(map(data))
    }
}

/**
 * Converts a [VolyumResult] to an [EmptyResult] by discarding the success data.
 * If the original result was a [VolyumResult.Success], the new result will be a [VolyumResult.Success] with `Unit` data.
 * If the original result was a [VolyumResult.Error], the new result will be a [VolyumResult.Error] with the same error.
 *
 * @param T The type of the success data in the original result.
 * @param E The type of the error in the original result.
 * @return An [EmptyResult] which is a [VolyumResult] with `Unit` as its success data type.
 */
fun <T, E : VolyumError> VolyumResult<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map { }
}

/**
 * Executes the given [action] if this [VolyumResult] is a [VolyumResult.Success].
 * Returns the original [VolyumResult] unchanged.
 *
 * @param T The type of the successful data.
 * @param E The type of the error.
 * @param action The action to execute with the successful data.
 * @return The original [VolyumResult].
 */
inline fun <T, E : VolyumError> VolyumResult<T, E>.onSuccess(action: (T) -> Unit): VolyumResult<T, E> {
    return when (this) {
        is VolyumResult.Error -> this
        is VolyumResult.Success -> {
            action(data)
            this
        }
    }
}

/**
 * Executes the given [action] if this [VolyumResult] is an [VolyumResult.Error].
 * The original [VolyumResult] is returned, regardless of whether it's an error or success.
 *
 * @param action The action to be executed with the error of type [E] if this is an [VolyumResult.Error].
 * @return The original [VolyumResult] instance.
 */
inline fun <T, E : VolyumError> VolyumResult<T, E>.onError(action: (E) -> Unit): VolyumResult<T, E> {
    return when (this) {
        is VolyumResult.Error -> {
            action(error)
            this
        }
        is VolyumResult.Success -> this
    }
}

/**
 * Checks if the [VolyumResult] is a [VolyumResult.Success].
 * @return `true` if the result is a success, `false` otherwise.
 */
fun VolyumResult<*, *>.isSuccess(): Boolean {
    return when (this) {
        is VolyumResult.Error<*> -> false
        is VolyumResult.Success<*> -> true
    }
}

typealias EmptyResult<E> = VolyumResult<Unit, E>
