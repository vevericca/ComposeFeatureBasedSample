package com.vevericca.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vevericca.domain.models.Product
import com.vevericca.uikit.models.PageState

@Composable
internal fun ProductsScreen(
    viewModel: ProductsViewModel = hiltViewModel(),
    onNavigate: () -> Unit
) {
    val state by viewModel.pageState.collectAsState()
    when (state) {
        is PageState.None -> Text("No Data Available")
        is PageState.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            CircularProgressIndicator()
        }

        is PageState.Error -> Text("Error: ${(state as PageState.Error).message}")
        is PageState.Success<ProductsScreenState> -> {
            FeatureAComposable((state as PageState.Success<ProductsScreenState>).data) {
                onNavigate.invoke()
            }
        }
    }
}

@Composable
private fun FeatureAComposable(state: ProductsScreenState, onArticleClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(text = "Hello, I'm the first feature")
        }
        items(items = state.data) { article ->
            ProductCard(article) {
                onArticleClick(it)
            }
        }

    }
}

@Composable
fun ProductCard(product: Product, onClick: (id: String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        border = BorderStroke(width = 2.dp, color = Color.Black)
    ) {
        Column(Modifier
            .wrapContentHeight()
            .padding(8.dp)) {
            Text(
                product.category,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.clickable {
                    println("Clicked ${product.id}")
                    onClick.invoke(product.id.toString())
                },
                text = product.title, style = MaterialTheme.typography.titleMedium
            )
            Text(
                product.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
