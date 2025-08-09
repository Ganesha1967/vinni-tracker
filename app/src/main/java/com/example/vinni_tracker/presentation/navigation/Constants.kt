package com.example.vinni_tracker.presentation.navigation

import com.example.vinni_tracker.R

object Constants {
  val BottomNavItems = listOf(
    // Home screen
    BottomNavItem(
      label = "Home",
      icon = R.drawable.ic_home,
      route = "home",
    ),
    // Tasks screen
    BottomNavItem(
      label = "Tasks",
      icon = R.drawable.ic_book,
      route = "tasks",
    ),
    // AI-help screen
    BottomNavItem(
      label = "AI-help",
      icon = R.drawable.ic_lightbulb_alt,
      route = "ai-help",
    ),
    // Settings screen
    BottomNavItem(
      label = "Settings",
      icon = R.drawable.ic_settings,
      route = "settings",
    ),
    // Profile screen
    BottomNavItem(
      label = "Profile",
      icon = R.drawable.ic_user,
      route = "profile",
    ),
  )
}
