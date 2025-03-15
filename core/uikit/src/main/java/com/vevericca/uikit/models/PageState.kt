package com.vevericca.uikit.models

sealed class PageState<out T> {
    data object None : PageState<Nothing>()
    data object Loading : PageState<Nothing>()
    data class Error(val message: String? = null) : PageState<Nothing>()
    data class Success<T>(val data: T) : PageState<T>()
}
