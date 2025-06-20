package com.example.vinni_tracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vinni_tracker.presentation.screen.home.HomeScreen
import com.example.vinni_tracker.presentation.theme.VinnitrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VinnitrackerTheme {
                HomeScreen()
            }
        }
    }
}