package com.example.vinni_tracker.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vinni_tracker.R

@Composable
fun TitleSection(greeting: String, modifier: Modifier = Modifier) {
  val login = "Ganesha"
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
