package com.vevericca.app_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vevericca.app_navigation.routes.FeatureRoute
import com.vevericca.ui.main.ProductsStartScreen

@Composable
fun ApplicationNavHost(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(modifier = modifier, navController = navController, startDestination = FeatureRoute.Products) {
        composable<FeatureRoute.Products> {
            ProductsStartScreen {
                navController.navigate(it)
            }
        }

    }
}
