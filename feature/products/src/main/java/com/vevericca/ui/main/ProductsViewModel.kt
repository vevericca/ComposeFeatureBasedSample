package com.vevericca.ui.main

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vevericca.domain.models.Product
import com.vevericca.domain.usecase.GetAllProductsUseCase
import com.vevericca.uikit.models.PageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ProductsViewModel @Inject constructor(
    private val useCase: GetAllProductsUseCase
): ViewModel() {

    private val _pageState = MutableStateFlow<PageState<ProductsScreenState>>(PageState.None)
    val pageState: StateFlow<PageState<ProductsScreenState>>
            get() = _pageState.asStateFlow()

    init {
        _pageState.update { PageState.Loading }
        viewModelScope.launch {
            useCase.invoke().onSuccess { result ->
                _pageState.update { PageState.Success(
                    ProductsScreenState(data = result)
                ) }
            }.onFailure { result ->
                _pageState.update { PageState.Error(result.message)
                }
            }
        }
    }
}

@Immutable
data class ProductsScreenState(
    val data: List<Product> = emptyList()
)