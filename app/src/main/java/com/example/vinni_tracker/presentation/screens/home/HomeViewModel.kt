package com.example.vinni_tracker.presentation.screens.home

import androidx.lifecycle.ViewModel
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

  val petsName = "Kuska"
  val petsStats = "Health: 80/100 HP"

  val cardDataStat = listOf(
    HomeCardData("pet_stats", petsName, petsStats),
    HomeCardData("user_stats", "Your Stats", "Lv: Master, 100 XP"),
  )
  val cardDataShopCalendar = listOf(
    HomeCardData("shop_screen", "Shop", "Purchase items"),
    HomeCardData("calendar_screen", "Calendar", "June 2025"),
  )

  fun getPartOfDay(): PartOfDay {
    val calendar: Calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)

    return when (hour) {
      in MORNING_START_HOUR..MORNING_END_HOUR -> PartOfDay.MORNING
      in AFTERNOON_START_HOUR..AFTERNOON_END_HOUR -> PartOfDay.AFTERNOON
      in EVENING_START_HOUR..EVENING_END_HOUR -> PartOfDay.EVENING
      else -> PartOfDay.NIGHT
    }
  }
}
