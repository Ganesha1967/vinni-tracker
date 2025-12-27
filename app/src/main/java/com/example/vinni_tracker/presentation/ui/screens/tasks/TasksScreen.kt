package com.example.vinni_tracker.presentation.ui.screens.tasks

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.vinni_tracker.designsystem.theme.VinniTrackerTheme

// Figure out where to add the notes themselves and how to save them
// Add the ability to delete notes
// Add the ability to rename by simply clicking on the task title
// Need to add a marker for today's date
// Do something with the weekly calendar????????????
// Can't see that a new entry has been added without scrolling down if added when there are already many entries on the screen
// Need to scroll to the newly appeared entry
// Add an icon indicating that the task can be edited
// Fix the addition timestamp
// Save the task list locally by day so it can be viewed
// Reset the task list when the next day starts
// Make the weekly calendar scrollable
// Output all data that shouldn't be placeholders/empty
// Add month and year

@Composable
fun TasksScreen(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Icon(
      imageVector = Icons.Default.LockClock,
      contentDescription = "Tasks Screen",
      tint = Color(0xFF0F9D58),
    )

    Text(text = "Tasks Screen", color = Color.Black)
  }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun TasksScreenPreview() {
  VinniTrackerTheme(dynamicColor = false, darkTheme = false) {
    TasksScreen()
  }
}
