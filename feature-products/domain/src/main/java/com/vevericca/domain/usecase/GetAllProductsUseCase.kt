package com.vevericca.domain.usecase

import com.vevericca.domain.interfaces.ProductsRepository
import com.vevericca.domain.models.Product
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val repo: ProductsRepository) {
    suspend fun invoke(): Result<List<Product>> {
        return repo.getAllProducts()
    }
}