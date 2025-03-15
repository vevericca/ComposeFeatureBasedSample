package com.vevericca.network.api

import com.vevericca.network.models.ProductsResponseItem
import retrofit2.http.GET

interface StoreApi {

    @GET("/products")
    suspend fun getAllProducts(
    ) : Result<List<ProductsResponseItem>>
}
