package com.example.vinni_tracker.presentation.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vinni_tracker.R
import com.example.vinni_tracker.data.CalendarData
import com.example.vinni_tracker.data.HomeCardData
import com.example.vinni_tracker.presentation.screens.home.components.CalendarGrid
import com.example.vinni_tracker.presentation.theme.VinniTrackerTheme
import java.util.Date

// reorganize the project structure to support desktop, tablet, smartwatch and mobile devices
// add pull to refresh
// move partOfDay to viewmodel
// calendar
@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier, viewModel: HomeViewModel = viewModel()) {
  val partOfDay = viewModel.getPartOfDay()
  val calendarData = viewModel.getCalendarData()

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
      .padding(16.dp)
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(13.dp),
  ) {
    TitleBlock(partOfDay = partOfDay)
    StudyTimerBlock(partOfDay = partOfDay, navController)
    Statistic(cardDataStat = viewModel.cardDataStat, navController = navController)
    ShopCalendar(shopCalendar = viewModel.shopCalendar, dataCalendar = calendarData, navController = navController)
    StudyStorageBlock(navController = navController)
    DailyRecommendationBlock(navController = navController)
    NewsBlock(navController = navController)
  }
}

@Composable
fun TitleBlock(partOfDay: PartOfDay, modifier: Modifier = Modifier) {
  val login = "Ganesha"
  val greeting = greetingState(partOfDay)
  val fullGreeting = stringResource(R.string.greeting_template, greeting, login) // pluralStringResource?
  val wish = stringResource(R.string.wish_good_day)

  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = modifier.fillMaxWidth(),
  ) {
    Row(
      modifier = Modifier.padding(5.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Column {
        Text(
          text = fullGreeting,
          style = MaterialTheme.typography.headlineSmall,
          color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
          text = wish,
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onBackground,
          modifier = Modifier.padding(top = 3.dp),
        )
      }
      Image(
        painter = painterResource(id = R.drawable.ic_cat),
        contentDescription = "Cat Icon",
        modifier = Modifier.size(50.dp),
      )
    }
  }
}

// move to viewmodel
@Composable
fun greetingState(partOfDay: PartOfDay): String {
  return when (partOfDay) {
    PartOfDay.MORNING -> stringResource(R.string.greeting_morning)
    PartOfDay.AFTERNOON -> stringResource(R.string.greeting_afternoon)
    PartOfDay.EVENING -> stringResource(R.string.greeting_evening)
    PartOfDay.NIGHT -> stringResource(R.string.greeting_night)
  }
}

@Composable
fun StudyTimerBlock(partOfDay: PartOfDay, navController: NavHostController, modifier: Modifier = Modifier) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(233.dp)
      .clickable { navController.navigate("study_timer") },
    shape = MaterialTheme.shapes.medium,
    colors = CardDefaults.cardColors(
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ),
  ) {
    val image = imageStudyTimer(partOfDay)

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

// move to viewmodel
@Composable
fun imageStudyTimer(partOfDay: PartOfDay): Painter {
  return when (partOfDay) {
    PartOfDay.MORNING -> painterResource(id = R.drawable.timer_afternoon)
    PartOfDay.AFTERNOON -> painterResource(id = R.drawable.timer_afternoon)
    PartOfDay.EVENING -> painterResource(id = R.drawable.timer_afternoon)
    PartOfDay.NIGHT -> painterResource(id = R.drawable.timer_afternoon)
  }
}

// fix the location
@Composable
fun Statistic(cardDataStat: List<HomeCardData>, navController: NavHostController, modifier: Modifier = Modifier) {
  LazyRow(
    modifier = Modifier.fillMaxWidth(),
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

// fix the location
@Composable
fun ShopCalendar(
  shopCalendar: List<HomeCardData>,
  dataCalendar: CalendarData,
  navController: NavHostController,
  modifier: Modifier = Modifier,
) {
  LazyRow(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    items(shopCalendar) { card ->
      Card(
        modifier = Modifier
          .width(179.dp)
          .height(123.dp)
          .clickable(enabled = card.id != "calendar_screen") { navController.navigate(card.id) },
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
                text = " HOT\n" +
                  "PRICE ",
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
            "calendar_screen" -> {
              CalendarView(
                dataCalendar = dataCalendar,
                onClick = {},
                startFromSunday = false,
                modifier = Modifier.fillMaxSize(),
              )
            }
          }
        }
      }
    }
  }
}

// add month and year (is it necessary?)
// fix size of calendar
// add svg-divider (is it necessary?)

// display the week with progress for this time (7 days)
// - those in which the person studied will be colored,
// and those that he missed will be empty
// (or colored in a different color - red, for example)
@Composable
fun CalendarView(dataCalendar: CalendarData, onClick: (Date) -> Unit, startFromSunday: Boolean, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Text(
      text = dataCalendar.monthYear,
      color = Color.White,
      fontSize = 14.sp,
    )

    Box(
      modifier = Modifier
        .fillMaxSize(),
      contentAlignment = Alignment.Center,
    ) {
      CalendarGrid(
        onClick = onClick,
        startFromSunday = startFromSunday,
        modifier = Modifier.wrapContentSize(),
      )
    }
  }
}

@Composable
fun StudyStorageBlock(navController: NavHostController, modifier: Modifier = Modifier) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(45.dp)
      .clickable { navController.navigate("study_storage") },
    shape = MaterialTheme.shapes.medium,
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.primaryContainer,
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ),
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
      horizontalAlignment = Alignment.Start,
    ) {
      Text(
        text = "Study Storage",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
      )
    }
  }
}

@Composable
fun DailyRecommendationBlock(navController: NavHostController, modifier: Modifier = Modifier) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(95.dp)
      .clickable { navController.navigate("recommendation_screen") },
    shape = MaterialTheme.shapes.medium,
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.primaryContainer,
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ),
  ) {
    Box(modifier = Modifier.fillMaxSize()) {
      Image(
        painter = painterResource(id = R.drawable.daily_news_afternoon),
        contentDescription = "Background image",
        modifier = Modifier
          .fillMaxSize(),
        contentScale = ContentScale.Crop,
      )
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(16.dp),
        horizontalAlignment = Alignment.Start,
      ) {
        Text(
          text = "Daily Recommendation",
          style = MaterialTheme.typography.titleMedium,
          color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Text(
          text = "Meditation: 3-10 min",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onPrimaryContainer,
          modifier = Modifier.padding(top = 4.dp),
        )
      }
    }
  }
}

@Composable
fun NewsBlock(navController: NavHostController, modifier: Modifier = Modifier) {
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
      Image(
        painter = painterResource(id = R.drawable.daily_news_afternoon),
        contentDescription = "Background image",
        modifier = Modifier
          .fillMaxSize(),
        contentScale = ContentScale.Crop,
      )
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(16.dp),
        horizontalAlignment = Alignment.Start,
      ) {
        Text(
          text = "News",
          style = MaterialTheme.typography.titleMedium,
          color = MaterialTheme.colorScheme.onPrimaryContainer,
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

// locale = "fr-rFR" - deal with translation
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun HomeScreenPreview() {
  VinniTrackerTheme(dynamicColor = false, darkTheme = false) {
    HomeScreen(navController = rememberNavController())
  }
}
