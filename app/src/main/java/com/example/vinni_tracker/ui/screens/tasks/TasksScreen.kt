package com.example.vinni_tracker.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TasksScreen(modifier: Modifier = Modifier) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Icon(
      imageVector = Icons.Default.Edit,
      contentDescription = "tasks",
      tint = Color(0xFF0F9D58),
    )

    Text(text = "Tasks", color = Color.Black)
  }
}
