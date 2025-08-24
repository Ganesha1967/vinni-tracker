package com.example.vinni_tracker.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun StudyTimerSection(image: Painter, navController: NavHostController, modifier: Modifier = Modifier) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .height(233.dp)
      .clickable { navController.navigate("study_timer") },
    shape = MaterialTheme.shapes.medium,
    colors = CardDefaults.cardColors(
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ),
  ) {
    Box(modifier = Modifier.fillMaxSize()) {
      Image(
        painter = image,
        contentDescription = "Background image",
        modifier = Modifier
          .fillMaxSize(),
        contentScale = ContentScale.Crop,
      )
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
      ) {
        Text(
          text = "Study Timer",
          style = MaterialTheme.typography.displayMedium,
          color = MaterialTheme.colorScheme.onBackground,
          textAlign = TextAlign.Center,
        )
      }
    }
  }
}
