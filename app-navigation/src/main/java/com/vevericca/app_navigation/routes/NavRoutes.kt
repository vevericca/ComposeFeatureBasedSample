package com.vevericca.app_navigation.routes

import kotlinx.serialization.Serializable

sealed class FeatureRoute {
    @Serializable
    data object Products: FeatureRoute()

    @Serializable
    data object Checkout: FeatureRoute()
}

