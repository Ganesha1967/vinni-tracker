package com.example.vinni_tracker.presentation.ui.screens.settings

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Support
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vinni_tracker.designsystem.theme.VinniTrackerTheme

// Themes - dynamic depending on the time of day, dark, light, auto
// Purchased theme - will be added after purchase
// Add normal screen scrolling
//
@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
  var notificationsEnabled by remember { mutableStateOf(true) }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(Color(0xFFEAF4F9))
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    item {
      Text(
        text = "Settings",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
      )
    }

    item {
      Spacer(modifier = Modifier.height(16.dp))
    }

    item {
      SettingsSection(title = "Profile & Account") {
        SettingsRow(Icons.Default.Person, "Edit Profile") { /* Navigate */ }
        SettingsRow(Icons.Default.Security, "Security") { /* Navigate */ }
      }
    }

    item {
      SettingsSection(title = "Appearance") {
        SettingsRow(Icons.Default.Language, "Language", trailingText = "English") { /* Navigate */ }
        SettingsSwitchRow(Icons.Default.Notifications, "Notifications", notificationsEnabled) {
          notificationsEnabled = it
        }
        SettingsRow(Icons.Default.Palette, "Theme", trailingText = "Dynamic") { /* Navigate */ }
      }
    }

    item {
      SettingsSection(title = "Help & Feedback") {
        SettingsRow(Icons.Default.Support, "Contact Support") { /* Navigate */ }
        SettingsRow(Icons.Default.Info, "FAQ") { /* Navigate */ }
        SettingsRow(Icons.Default.Share, "Share App") { /* Share */ }
      }
    }

    item {
      SettingsSection(title = "About") {
        SettingsRow(Icons.Default.Support, "App Version") { /* Navigate */ }
      }
    }

    item {
      SettingsSection(title = "Account") {
        SettingsRow(Icons.Default.Support, "Add account") { /* Navigate */ }
        SettingsRow(Icons.Default.Info, "Delete account") { /* Navigate */ }
        SettingsRow(Icons.Default.Share, "Leave Account") { /* Share */ }
      }
    }
  }
}

@Composable
private fun SettingsSection(title: String, content: @Composable ColumnScope.() -> Unit) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(containerColor = Color.White),
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Text(text = title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.DarkGray)
      Spacer(modifier = Modifier.height(8.dp))
      content()
    }
  }
}

@Composable
private fun SettingsRow(icon: ImageVector, text: String, trailingText: String? = null, onClick: () -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick() }
      .padding(vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Icon(
      imageVector = icon, contentDescription = null, modifier = Modifier.size(24.dp),
      tint = MaterialTheme.colorScheme.onBackground,
    )
    Spacer(modifier = Modifier.width(16.dp))
    Text(text = text, fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.weight(1f))
    if (trailingText != null) {
      Text(text = trailingText, fontSize = 14.sp, color = Color.Gray)
    }
    Icon(
      imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null,
      tint = MaterialTheme.colorScheme.onBackground,
    )
  }
}

@Composable
private fun SettingsSwitchRow(icon: ImageVector, text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Icon(
      imageVector = icon,
      contentDescription = null,
      modifier = Modifier.size(24.dp),
      tint = MaterialTheme.colorScheme.onBackground,
    )
    Spacer(modifier = Modifier.width(16.dp))
    Text(text = text, fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.weight(1f))
    Switch(
      checked = checked,
      onCheckedChange = onCheckedChange,
      colors = SwitchColors(
        Color.White,
        checkedTrackColor = Color.Black,
        checkedBorderColor = Color.White,
        checkedIconColor = Color.Black,
        uncheckedThumbColor = Color.White,
        uncheckedTrackColor = Color.White,
        uncheckedBorderColor = Color.White,
        uncheckedIconColor = Color.White,
        disabledCheckedThumbColor = Color.White,
        disabledCheckedTrackColor = Color.White,
        disabledCheckedBorderColor = Color.White,
        disabledCheckedIconColor = Color.White,
        disabledUncheckedThumbColor = Color.White,
        disabledUncheckedTrackColor = Color.White,
        disabledUncheckedBorderColor = Color.White,
        disabledUncheckedIconColor = Color.White,
      ),
    )
  }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun SettingsScreenPreview() {
  VinniTrackerTheme(dynamicColor = false, darkTheme = false) {
    SettingsScreen()
  }
}
