package com.vevericca.domain.interfaces

import com.vevericca.domain.models.Product

interface ProductsRepository {

    suspend fun getAllProducts(): Result<List<Product>>
}