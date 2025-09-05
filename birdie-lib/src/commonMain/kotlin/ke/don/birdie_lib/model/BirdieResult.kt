package ke.don.birdie_lib.model


sealed interface BirdieResult<out D, out E: Error> {
    data class Success<out D>(val data: D): BirdieResult<D, Nothing>
    data class Error<out E: ke.don.birdie_lib.model.Error>(val error: E): BirdieResult<Nothing, E>
}

inline fun <T, E: Error, R> BirdieResult<T, E>.map(map: (T) -> R): BirdieResult<R, E> {
    return when(this) {
        is BirdieResult.Error -> BirdieResult.Error(error)
        is BirdieResult.Success -> BirdieResult.Success(map(data))
    }
}

fun <T, E: Error> BirdieResult<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {  }
}

inline fun <T, E: Error> BirdieResult<T, E>.onSuccess(action: (T) -> Unit): BirdieResult<T, E> {
    return when(this) {
        is BirdieResult.Error -> this
        is BirdieResult.Success -> {
            action(data)
            this
        }
    }
}
inline fun <T, E: Error> BirdieResult<T, E>.onError(action: (E) -> Unit): BirdieResult<T, E> {
    return when(this) {
        is BirdieResult.Error -> {
            action(error)
            this
        }
        is BirdieResult.Success -> this
    }
}

typealias EmptyResult<E> = BirdieResult<Unit, E>