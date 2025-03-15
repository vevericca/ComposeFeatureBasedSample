package com.vevericca.data

import com.vevericca.data.dto.ProductDTO

interface ProductsRepository {

    suspend fun getAllProducts(): Result<List<ProductDTO>>
}