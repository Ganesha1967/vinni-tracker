package com.example.vinni_tracker.presentation.navigation

import com.example.vinni_tracker.R

object Constants {
  val BottomNavItems = listOf(
    // Home screen
    BottomNavItem(
      label = "Home",
      icon = R.drawable.home,
      route = "home",
    ),
    // Tasks screen
    BottomNavItem(
      label = "Tasks",
      icon = R.drawable.book,
      route = "tasks",
    ),
    // AI-help screen
    BottomNavItem(
      label = "AI-help",
      icon = R.drawable.lightbulb_alt,
      route = "ai-help",
    ),
    // Profile screen
    BottomNavItem(
      label = "Profile",
      icon = R.drawable.user,
      route = "profile",
    ),
  )
}
