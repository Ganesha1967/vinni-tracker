package com.example.vinni_tracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.vinni_tracker.presentation.navigation.BottomNavigationBar
import com.example.vinni_tracker.presentation.navigation.NavHostContainer
import com.example.vinni_tracker.presentation.theme.VinnitrackerTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      VinnitrackerTheme(dynamicColor = false, darkTheme = false) {
        val navController = rememberNavController()
        Surface(color = Color.White) {
          Scaffold(
            bottomBar = {
              BottomNavigationBar(navController = navController, modifier = Modifier)
            }, content = { padding ->
              NavHostContainer(navController = navController, padding = padding, modifier = Modifier)
            },
          )
        }
      }
    }
  }
}
