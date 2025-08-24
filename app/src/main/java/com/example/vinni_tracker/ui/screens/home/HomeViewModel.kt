package com.example.vinni_tracker.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.vinni_tracker.R
import com.example.vinni_tracker.data.HomeCardData
import java.util.Calendar

enum class PartOfDay {
  MORNING,
  AFTERNOON,
  EVENING,
  NIGHT,
}

class HomeViewModel : ViewModel() {
  companion object {
    private const val MORNING_START_HOUR = 6
    private const val MORNING_END_HOUR = 11
    private const val AFTERNOON_START_HOUR = 12
    private const val AFTERNOON_END_HOUR = 17
    private const val EVENING_START_HOUR = 18
    private const val EVENING_END_HOUR = 23
  }

  val calendar: Calendar = Calendar.getInstance()
  val hour = calendar.get(Calendar.HOUR_OF_DAY)

  // State???
  val partOfDay: PartOfDay = when (hour) {
    in MORNING_START_HOUR..MORNING_END_HOUR -> PartOfDay.MORNING
    in AFTERNOON_START_HOUR..AFTERNOON_END_HOUR -> PartOfDay.AFTERNOON
    in EVENING_START_HOUR..EVENING_END_HOUR -> PartOfDay.EVENING
    else -> PartOfDay.NIGHT
  }

  val greetingResId: Int = when (partOfDay) {
    PartOfDay.MORNING -> R.string.greeting_morning
    PartOfDay.AFTERNOON -> R.string.greeting_afternoon
    PartOfDay.EVENING -> R.string.greeting_evening
    PartOfDay.NIGHT -> R.string.greeting_night
  }

  val studyTimerImageResId: Int = when (partOfDay) {
    PartOfDay.MORNING -> R.drawable.timer_afternoon
    PartOfDay.AFTERNOON -> R.drawable.timer_afternoon
    PartOfDay.EVENING -> R.drawable.timer_afternoon
    PartOfDay.NIGHT -> R.drawable.timer_afternoon
  }

  val shopNews = listOf(
    HomeCardData(
      id = "shop_screen",
      title = "Shop",
      contentDescription = "Purchase items",
      imageResId = R.drawable.ic_shop,
    ),
    HomeCardData(
      id = "news_screen",
      title = "News",
      contentDescription = "News",
      imageResId = 0,
    ),
  )

  val petsName = "Kuska"
  val petsStats = "Health: 80/100 HP"

  val cardDataStat = listOf(
    HomeCardData(
      id = "pet_stats",
      title = petsName,
      contentDescription = petsStats,
      imageResId = when (partOfDay) {
        PartOfDay.MORNING -> R.drawable.pet_afternoon
        PartOfDay.AFTERNOON -> R.drawable.pet_afternoon
        PartOfDay.EVENING -> R.drawable.pet_afternoon
        PartOfDay.NIGHT -> R.drawable.pet_afternoon
      },
    ),
    HomeCardData(
      id = "user_stats",
      title = "Your stats",
      contentDescription = "Lv: Master, 100 XP",
      imageResId = when (partOfDay) {
        PartOfDay.MORNING -> R.drawable.user_afternoon
        PartOfDay.AFTERNOON -> R.drawable.user_afternoon
        PartOfDay.EVENING -> R.drawable.user_afternoon
        PartOfDay.NIGHT -> R.drawable.user_afternoon
      },
    ),
  )
}
