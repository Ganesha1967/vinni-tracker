package com.example.vinni_tracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vinni_tracker.presentation.navigation.Constants
import com.example.vinni_tracker.presentation.screens.ai_help.AiHelpScreen
import com.example.vinni_tracker.presentation.screens.home.HomeScreen
import com.example.vinni_tracker.presentation.screens.profile.ProfileScreen
import com.example.vinni_tracker.presentation.screens.settings.SettingsScreen
import com.example.vinni_tracker.presentation.screens.tasks.TasksScreen
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

@Composable
fun NavHostContainer(navController: NavHostController, padding: PaddingValues, modifier: Modifier = Modifier) {
  NavHost(
    navController = navController,
    startDestination = "home",
    modifier = modifier.padding(paddingValues = padding),
    builder = {
      composable("home") {
        HomeScreen()
      }

      composable("tasks") {
        TasksScreen()
      }

      composable("ai-help") {
        AiHelpScreen()
      }

      composable("settings") {
        SettingsScreen()
      }

      composable("profile") {
        ProfileScreen()
      }
    },
  )
}

@Composable
fun BottomNavigationBar(navController: NavHostController, modifier: Modifier = Modifier) {
  NavigationBar(
    containerColor = Color(0xFF0F9D58),
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Constants.BottomNavItems.forEach { navItem ->

      NavigationBarItem(
        selected = currentRoute == navItem.route,
        onClick = {
          navController.navigate(navItem.route)
        },
        icon = {
          Icon(imageVector = navItem.icon, contentDescription = navItem.label)
        },
        label = {
          Text(text = navItem.label)
        },
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
          selectedIconColor = Color.White,
          unselectedIconColor = Color.White,
          selectedTextColor = Color.White,
          indicatorColor = Color(0xFF195334),
        ),
      )
    }
  }
}
