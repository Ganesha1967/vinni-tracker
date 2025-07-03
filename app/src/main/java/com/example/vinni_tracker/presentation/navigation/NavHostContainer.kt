package com.example.vinni_tracker.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vinni_tracker.presentation.screens.ai_help.AiHelpScreen
import com.example.vinni_tracker.presentation.screens.home.HomeScreen
import com.example.vinni_tracker.presentation.screens.profile.ProfileScreen
import com.example.vinni_tracker.presentation.screens.tasks.TasksScreen

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

      composable("profile") {
        ProfileScreen()
      }
    },
  )
}
