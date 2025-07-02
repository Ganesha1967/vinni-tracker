package com.example.vinni_tracker.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings

object Constants {
  val BottomNavItems = listOf(
    // Home screen
    BottomNavItem(
      label = "Home",
      icon = Icons.Filled.Home,
      route = "home",
    ),
    // Tasks screen
    BottomNavItem(
      label = "Tasks",
      icon = Icons.Filled.Edit,
      route = "tasks",
    ),
    // AI-help screen
    BottomNavItem(
      label = "AI-help",
      icon = Icons.Filled.Info,
      route = "ai-help",
    ),
    // Settings screen
    BottomNavItem(
      label = "Settings",
      icon = Icons.Filled.Settings,
      route = "settings",
    ),
    // Profile screen
    BottomNavItem(
      label = "Profile",
      icon = Icons.Filled.Person,
      route = "profile",
    ),
  )
}
