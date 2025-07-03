package com.example.vinni_tracker.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar(
  titleGreetings: String,
  titleWish: String,
  containerColor: Color,
  modifier: Modifier = Modifier,
  titleColor: Color = MaterialTheme.colorScheme.primary,
) {
  TopAppBar(
    modifier = modifier,
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = containerColor,
      titleContentColor = titleColor,
    ),
    title = {
      Column {
        Text(text = titleGreetings)
        Text(
          text = titleWish,
          style = MaterialTheme.typography.bodySmall.copy(
            color = titleColor.copy(alpha = 0.8f),
          ),
        )
      }
    },
  )
}
