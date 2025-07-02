package com.example.vinni_tracker.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
  // Text below icon
  val label: String,
  // Icon
  val icon: ImageVector,
  // Route to the specific screen
  val route: String,
)
