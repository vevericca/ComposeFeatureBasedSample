package com.vevericca.ui.main

import androidx.compose.runtime.Composable

@Composable
fun ProductsStartScreen(
    onNavigate: () -> Unit
) {
    ProductsScreen { onNavigate.invoke() }
}
