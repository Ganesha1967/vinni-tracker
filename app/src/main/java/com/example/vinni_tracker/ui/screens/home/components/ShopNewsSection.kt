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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vinni_tracker.data.HomeCardData

// rewrite
// fix the location
// add background for news
@Composable
fun ShopNewsSection(shopNews: List<HomeCardData>, navController: NavHostController, modifier: Modifier = Modifier) {
  LazyRow(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    items(shopNews) { card ->
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
          when (card.id) {
            "shop_screen" -> {
              Text(
                text = " HOT\nPRICE ",
                style = MaterialTheme.typography.labelSmall.copy(
                  color = Color(0xFFF3BE3B),
                  fontWeight = FontWeight.Bold,
                  fontSize = 10.sp,
                ),
                modifier = Modifier
                  .align(Alignment.TopStart)
                  .padding(8.dp),
              )
              Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
              ) {
                Image(
                  painter = painterResource(id = card.imageResId),
                  contentDescription = "${card.title} icon",
                  modifier = Modifier.size(48.dp),
                  contentScale = ContentScale.Fit,
                )
                Text(
                  text = card.title,
                  style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                  color = MaterialTheme.colorScheme.onPrimaryContainer,
                  textAlign = TextAlign.Center,
                )
              }
            }
            "news_screen" -> {
              Card(
                modifier = Modifier
                  .fillMaxWidth()
                  .height(95.dp)
                  .clickable { navController.navigate("news_screen") },
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(
                  containerColor = MaterialTheme.colorScheme.primaryContainer,
                  contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
              ) {
                Box(modifier = Modifier.fillMaxSize()) {
                  Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                  ) {
                    Text(
                      text = "News",
                      style = MaterialTheme.typography.titleMedium,
                      color = MaterialTheme.colorScheme.onPrimaryContainer,
                      modifier = Modifier.padding(top = 20.dp),
                    )
                    Text(
                      text = "Latest updates",
                      style = MaterialTheme.typography.bodySmall,
                      color = MaterialTheme.colorScheme.onPrimaryContainer,
                      modifier = Modifier.padding(top = 4.dp),
                    )
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
