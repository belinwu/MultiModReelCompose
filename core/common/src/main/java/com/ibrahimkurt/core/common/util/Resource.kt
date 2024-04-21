package com.ibrahimkurt.core.common.util

import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING


interface ResourceProvider {
    fun getString(resourceId: Int): String
}

data class ErrorMessage(
    val message: String = EMPTY_STRING,
    val resourceId: Int? = null
)

sealed interface Resource<out T> {
    data class Success<T>(val data: T) : Resource<T> {
        suspend fun<T : Any, N : Any> Resource<T>.getDataOrNull(dataCallBack: suspend (T) -> N?): N? {
            return when (this) {
                is Success -> dataCallBack(this.data)
                is Error -> null
            }
        }
    }

    data class Error<T>(val error: ErrorMessage) : Resource<T> {
        fun getErrorMessage(resourceProvider: ResourceProvider): String {
            return error.message.ifBlank { error.resourceId?.let { resourceProvider.getString(it) } ?: "Unknown error" }
        }

        fun toPagingException(): PagingException {
            return PagingException(error.message, error.resourceId ?: 0)
        }
    }
}

suspend fun <T : Any, N : Any> Resource<T>.map(data: suspend (T) -> N): Resource<N> {
    return when (this) {
        is Resource.Success -> Resource.Success(data(this.data))
        is Resource.Error -> Resource.Error(this.error)
    }
}