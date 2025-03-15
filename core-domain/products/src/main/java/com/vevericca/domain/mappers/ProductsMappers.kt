package com.vevericca.domain.mappers

import com.vevericca.data.dto.ProductDTO
import com.vevericca.domain.models.Product
import com.vevericca.domain.models.Rating

internal fun List<ProductDTO>.toProducts(): List<Product> {
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
