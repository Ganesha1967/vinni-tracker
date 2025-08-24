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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vinni_tracker.data.HomeCardData

// fix the location
@Composable
fun StatsSection(cardDataStat: List<HomeCardData>, navController: NavHostController, modifier: Modifier = Modifier) {
  LazyRow(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    items(cardDataStat) { card ->
      Card(
        modifier = Modifier
          .width(179.dp)
          .height(123.dp)
          .clickable { navController.navigate(card.id) },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer,
          contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
      ) {
        Box(modifier = Modifier.fillMaxSize()) {
          Image(
            painter = painterResource(card.imageResId),
            contentDescription = "Background image",
            modifier = Modifier
              .fillMaxSize(),
            contentScale = ContentScale.Crop,
          )
          Column(
            modifier = Modifier
              .fillMaxSize()
              .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
          ) {
            Text(
              text = card.title,
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.onPrimaryContainer,
              textAlign = TextAlign.Center,
            )
            Text(
              text = card.contentDescription,
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onPrimaryContainer,
              textAlign = TextAlign.Center,
              modifier = Modifier.padding(top = 4.dp),
            )
          }
        }
      }
    }
  }
}
