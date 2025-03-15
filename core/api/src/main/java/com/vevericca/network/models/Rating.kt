package com.vevericca.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("rate")
    val rate: Double
)