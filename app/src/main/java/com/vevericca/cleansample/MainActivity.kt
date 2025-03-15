package com.vevericca.cleansample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.vevericca.app_navigation.ApplicationNavHost
import com.vevericca.cleansample.ui.theme.CleanArchitectureBasedSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanArchitectureBasedSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ApplicationNavHost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

