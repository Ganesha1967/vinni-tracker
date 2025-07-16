package com.example.vinni_tracker.data

import kotlinx.collections.immutable.ImmutableList
import java.util.Date

data class CalendarData(val dates: ImmutableList<Pair<Date, Boolean>>, val monthYear: String, val month: Int, val year: Int)
