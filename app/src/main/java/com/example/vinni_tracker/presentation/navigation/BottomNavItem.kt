package com.example.vinni_tracker.presentation.navigation

data class BottomNavItem(
  // Text below icon
  val label: String,
  // Icon
  val icon: Int,
  // Route to the specific screen
  val route: String,
)
