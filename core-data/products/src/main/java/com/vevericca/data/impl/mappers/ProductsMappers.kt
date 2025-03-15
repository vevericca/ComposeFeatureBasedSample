package com.vevericca.data.impl.mappers

import com.vevericca.data.dto.ProductDTO
import com.vevericca.data.dto.RatingDTO
import com.vevericca.network.models.ProductsResponseItem

internal fun List<ProductsResponseItem>.toProductsDTO(): List<ProductDTO> {
    return this.map { p ->
        ProductDTO(
            category = p.category,
            description = p.description,
            id = p.id,
            image = p.image,
            price = p.price,
            rating = RatingDTO(p.rating.count, p.rating.rate),
            title = p.title
        )
    }
}
