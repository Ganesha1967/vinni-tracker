package com.example.vinni_tracker.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vinni_tracker.ui.screens.home.components.DailyRecommendationSection
import com.example.vinni_tracker.ui.screens.home.components.ShopNewsSection
import com.example.vinni_tracker.ui.screens.home.components.StatsSection
import com.example.vinni_tracker.ui.screens.home.components.StudyStorageSection
import com.example.vinni_tracker.ui.screens.home.components.StudyTimerSection
import com.example.vinni_tracker.ui.screens.home.components.TitleSection
import com.example.vinni_tracker.ui.theme.VinniTrackerTheme

// - reorganize the project structure to support desktop, tablet, smartwatch and mobile devices
// - deal with the image extension
// - add pull to refresh
// - think about moving the login to another line in Title Block
// or tell the user that there is a max number of characters (?)
// - think about what to use background for the news
// - reduce the distance between the navigation button and the recommendation button (?)
@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier, viewModel: HomeViewModel = viewModel()) {
  val greetingForTitle = stringResource(id = viewModel.greetingResId)
  val backgroundForStudyTimer = painterResource(id = viewModel.studyTimerImageResId)
  val cardDataStat = viewModel.cardDataStat
  val shopNews = viewModel.shopNews
  val verticalScrollableState = rememberScrollState()

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
      .padding(16.dp)
      .verticalScroll(verticalScrollableState),
    verticalArrangement = Arrangement.spacedBy(13.dp),
  ) {
    TitleSection(greetingForTitle)
    StudyTimerSection(backgroundForStudyTimer, navController)
    StatsSection(cardDataStat, navController)
    ShopNewsSection(shopNews, navController)
    StudyStorageSection(navController)
    DailyRecommendationSection(navController)
  }
}

// locale = "fr-rFR" - deal with translation
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun HomeScreenPreview() {
  VinniTrackerTheme(dynamicColor = false, darkTheme = false) {
    HomeScreen(navController = rememberNavController())
  }
}
