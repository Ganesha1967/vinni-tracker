package com.example.vinni_tracker.presentation.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    // Icon on the screen
    Icon(
      imageVector = Icons.Default.Settings,
      contentDescription = "settings",
      tint = Color(0xFF0F9D58),
    )
    // Text on the screen
    Text(text = "Settings", color = Color.Black)
  }
}
