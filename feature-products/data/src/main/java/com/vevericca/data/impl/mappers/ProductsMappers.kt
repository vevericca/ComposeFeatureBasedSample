package com.vevericca.data.impl.mappers

import com.vevericca.domain.models.Product
import com.vevericca.domain.models.Rating
import com.vevericca.network.models.ProductsResponseItem

internal fun List<ProductsResponseItem>.toProducts(): List<Product> {
    return this.map { p ->
        Product(
            category = p.category,
            description = p.description,
            id = p.id,
            image = p.image,
            price = p.price,
            rating = Rating(p.rating.count, p.rating.rate),
            title = p.title
        )
    }
}