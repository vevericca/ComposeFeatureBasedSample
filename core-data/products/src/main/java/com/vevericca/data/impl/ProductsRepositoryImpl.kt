package com.vevericca.data.impl

import com.vevericca.data.ProductsRepository
import com.vevericca.data.dto.ProductDTO
import com.vevericca.data.impl.mappers.toProductsDTO
import com.vevericca.network.api.StoreApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(private val api: StoreApi): ProductsRepository {
    override suspend fun getAllProducts(): Result<List<ProductDTO>> {
        return try {
            Result.success(api.getAllProducts().getOrThrow().toProductsDTO())
        } catch (e:Exception) {
            Result.failure(e)
        }
    }
}
