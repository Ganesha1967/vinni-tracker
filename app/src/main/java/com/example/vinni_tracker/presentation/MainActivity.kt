package com.example.vinni_tracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.vinni_tracker.presentation.navigation.BottomNavigationBar
import com.example.vinni_tracker.presentation.navigation.NavHostContainer
import com.example.vinni_tracker.presentation.theme.VinniTrackerTheme
// import dagger.hilt.android.AndroidEntryPoint

// @AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      VinniTrackerTheme(dynamicColor = false, darkTheme = false) {
        val navController = rememberNavController()
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
