package com.example.vinni_tracker.presentation.ui.screens.home.news

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.vinni_tracker.designsystem.theme.VinniTrackerTheme

// add the ability for an administrator to add news from the admin side, not through code and app updates → split roles into regular users and admin (i.e., me)
// add a like counter?
// change the colors of likes and dislikes to green and red (use SVG???)

@Composable
fun NewsScreen(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Icon(
      imageVector = Icons.Default.Person,
      contentDescription = "News",
      tint = Color(0xFF0F9D58),
    )

    Text(text = "News", color = Color.Black)
  }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun NewsScreenPreview() {
  VinniTrackerTheme(dynamicColor = false, darkTheme = false) {
    NewsScreen()
  }
}
