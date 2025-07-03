package com.example.vinni_tracker.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.vinni_tracker.presentation.screens.home.components.SmallTopAppBar

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
  // move to Theme.kt
  val myColor = Color(0xFFE2EFF2)

  // hide
  val login = "Ganesha"
  val partOfTheDay = "Good Afternoon"

  val greating = "$partOfTheDay, $login"
  val wish = "We Wish you a good day!"

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(myColor),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
  ) {
    SmallTopAppBar(
      titleGreetings = greating,
      titleWish = wish,
      containerColor = myColor,
    )
  }
}

@Preview
@Composable
private fun HomeScreenPreview() {
  HomeScreen()
}
