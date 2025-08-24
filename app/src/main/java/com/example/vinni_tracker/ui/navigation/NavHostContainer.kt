package com.example.vinni_tracker.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vinni_tracker.ui.screens.ai_help.AiHelpScreen
import com.example.vinni_tracker.ui.screens.home.HomeScreen
import com.example.vinni_tracker.ui.screens.home.pets.PetStatsScreen
import com.example.vinni_tracker.ui.screens.home.recommendation.RecommendationScreen
import com.example.vinni_tracker.ui.screens.home.shop.ShopScreen
import com.example.vinni_tracker.ui.screens.home.storage.StudyStorageScreen
import com.example.vinni_tracker.ui.screens.home.timer.StudyTimerScreen
import com.example.vinni_tracker.ui.screens.home.user.UserStatsScreen
import com.example.vinni_tracker.ui.screens.profile.ProfileScreen
import com.example.vinni_tracker.ui.screens.settings.SettingsScreen
import com.example.vinni_tracker.ui.screens.tasks.TasksScreen

@Composable
fun NavHostContainer(navController: NavHostController, padding: PaddingValues, modifier: Modifier = Modifier) {
  NavHost(
    navController = navController,
    startDestination = "home",
    modifier = modifier.padding(paddingValues = padding),
    builder = {
      composable("home") {
        HomeScreen(navController = navController)
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
      composable("study_timer") {
        StudyTimerScreen()
      }
      composable("pet_stats") {
        PetStatsScreen()
      }
      composable("user_stats") {
        UserStatsScreen()
      }
      composable("shop_screen") {
        ShopScreen()
      }
      composable("study_storage") {
        StudyStorageScreen()
      }
      composable("recommendation_screen") {
        RecommendationScreen()
      }
      composable("news_screen") {
        Text("News Screen")
      }
    },
  )
}
