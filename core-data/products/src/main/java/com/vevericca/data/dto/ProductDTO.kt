package com.vevericca.data.dto

data class ProductDTO(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDTO,
    val title: String
)

data class RatingDTO(
    val count: Int,
    val rate: Double
)
