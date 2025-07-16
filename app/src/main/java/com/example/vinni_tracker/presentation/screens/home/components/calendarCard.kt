package com.example.vinni_tracker.presentation.screens.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun Date.formatToCalendarDay(): String = SimpleDateFormat("d", Locale.getDefault()).format(this)

fun Date.formatToWeekDay(): Int = Calendar.getInstance().apply {
  time = this@formatToWeekDay
}.get(Calendar.DAY_OF_WEEK)

@Composable
private fun CalendarCell(date: Date, signal: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
  val text = date.formatToCalendarDay()
  val cal = Calendar.getInstance().apply { time = date }
  val today = Calendar.getInstance()
  val isToday = today.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
    today.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)

  Box(
    modifier = modifier
      .aspectRatio(1f)
      .clip(CircleShape)
      .clickable(onClick = onClick),
    contentAlignment = Alignment.Center,
  ) {
    if (isToday) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(2.dp)
          .clip(CircleShape)
          .border(1.dp, Color.White, CircleShape),
      )
    }
    Text(
      text = text,
      fontSize = 10.sp,
      color = Color.White,
    )
  }
}

private fun Int.getDayOfWeek3Letters(): String? = Calendar.getInstance().apply {
  set(Calendar.DAY_OF_WEEK, this@getDayOfWeek3Letters)
}.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault())

@Composable
private fun WeekdayCell(weekday: Int, modifier: Modifier = Modifier) {
  val text = weekday.getDayOfWeek3Letters()?.take(2)?.uppercase() ?: ""
  Box(
    modifier = modifier
      .aspectRatio(1f),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = text,
      color = Color.White,
      fontSize = 8.sp,
    )
  }
}

@Composable
fun CalendarGrid(onClick: (Date) -> Unit, startFromSunday: Boolean, modifier: Modifier = Modifier) {
  val dates = getCurrentWeekDates(startFromSunday).toImmutableList()
  val weekdayFirstDay = dates.first().first.formatToWeekDay()
  val weekdays = getWeekDays(startFromSunday)

  CalendarCustomLayout(modifier = modifier) {
    weekdays.forEach {
      WeekdayCell(weekday = it)
    }
    repeat(if (!startFromSunday) weekdayFirstDay - 2 else weekdayFirstDay - 1) {
      Spacer(modifier = Modifier)
    }
    dates.forEach {
      CalendarCell(date = it.first, signal = it.second, onClick = { onClick(it.first) })
    }
  }
}

fun getWeekDays(startFromSunday: Boolean): ImmutableList<Int> {
  val lista = (1..7).toList()
  return (if (startFromSunday) lista else lista.drop(1) + lista.take(1)).toImmutableList()
}

fun getCurrentWeekDates(startFromSunday: Boolean): List<Pair<Date, Boolean>> {
  val calendar = Calendar.getInstance()
  val firstDayOfWeek = if (startFromSunday) Calendar.SUNDAY else Calendar.MONDAY
  calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek)
  calendar.set(Calendar.HOUR_OF_DAY, 0)
  calendar.set(Calendar.MINUTE, 0)
  calendar.set(Calendar.SECOND, 0)
  calendar.set(Calendar.MILLISECOND, 0)

  val dates = mutableListOf<Pair<Date, Boolean>>()
  repeat(7) {
    dates.add(Pair(calendar.time, false))
    calendar.add(Calendar.DAY_OF_WEEK, 1)
  }
  return dates
}

@Composable
private fun CalendarCustomLayout(
  modifier: Modifier = Modifier
    .fillMaxSize()
    .padding(16.dp),
  horizontalGapDp: Dp = 2.dp,
  verticalGapDp: Dp = 2.dp,
  content: @Composable () -> Unit,
) {
  val horizontalGap = with(LocalDensity.current) { horizontalGapDp.roundToPx() }
  val verticalGap = with(LocalDensity.current) { verticalGapDp.roundToPx() }

  Layout(
    content = content,
    modifier = modifier,
  ) { measurables, constraints ->
    val totalWidthWithoutGap = constraints.maxWidth - (horizontalGap * 6)
    val singleWidth = totalWidthWithoutGap / 7

    val xPos: MutableList<Int> = mutableListOf()
    val yPos: MutableList<Int> = mutableListOf()
    var currentX = 0
    var currentY = 0

    measurables.forEachIndexed { index, _ ->
      xPos.add(currentX)
      yPos.add(currentY)

      if (index == 6) {
        currentX = 0
        currentY += singleWidth + verticalGap
      } else {
        currentX += singleWidth + horizontalGap
      }
    }

    val placeables: List<Placeable> = measurables.map { measurable ->
      measurable.measure(constraints.copy(maxHeight = singleWidth, maxWidth = singleWidth))
    }

    layout(
      width = constraints.maxWidth,
      height = currentY + singleWidth + verticalGap,
    ) {
      placeables.forEachIndexed { index, placeable ->
        placeable.placeRelative(
          x = xPos[index],
          y = yPos[index],
        )
      }
    }
  }
}
