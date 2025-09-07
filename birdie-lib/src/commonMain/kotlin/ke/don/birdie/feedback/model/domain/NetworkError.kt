package ke.don.birdie.feedback.model.domain

data class NetworkError(
    val category: NetworkErrorCategory = NetworkErrorCategory.UNKNOWN,
    val message: String? = null,
    val code: Int? = null,
): Error