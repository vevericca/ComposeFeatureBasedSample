package com.vevericca.data.impl

import com.vevericca.data.impl.mappers.toProducts
import com.vevericca.domain.interfaces.ProductsRepository
import com.vevericca.domain.models.Product
import com.vevericca.network.api.StoreApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(private val api: StoreApi): ProductsRepository {
    override suspend fun getAllProducts(): Result<List<Product>> {
        return try {
            Result.success(api.getAllProducts().getOrThrow().toProducts())
        } catch (e:Exception) {
            Result.failure(e)
        }
    }
}
