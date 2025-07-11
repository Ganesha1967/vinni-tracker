package com.example.vinni_tracker.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.vinni_tracker.presentation.theme.SecondaryContainerLight

// пререпроверить цвета
private val DarkColorScheme = darkColorScheme(
  primary = PrimaryDark,
  secondary = SecondaryDark,
  tertiary = TertiaryDark,
  onPrimary = OnPrimaryDark,
  onSecondary = OnSecondaryDark,
  onTertiary = OnTertiaryDark,
  background = BackgroundDark,
  surface = SurfaceDark,
  onBackground = OnBackgroundDark,
  onSurface = OnSurfaceDark,
  primaryContainer = PrimaryContainerDark,
  onPrimaryContainer = OnPrimaryContainerDark,
  secondaryContainer = SecondaryContainerDark,
  onSecondaryContainer = OnSecondaryContainerDark,

)

private val LightColorScheme = lightColorScheme(
  primary = PrimaryLight,
  secondary = SecondaryLight,
  tertiary = TertiaryLight,
  onPrimary = OnPrimaryLight,
  onSecondary = OnSecondaryLight,
  onTertiary = OnTertiaryLight,
  background = BackgroundLight,
  surface = SurfaceLight,
  onBackground = OnBackgroundLight,
  onSurface = OnSurfaceLight,
  primaryContainer = PrimaryContainerLight,
  onPrimaryContainer = OnPrimaryContainerLight,
  secondaryContainer = SecondaryContainerLight,
  onSecondaryContainer = OnSecondaryContainerLight,
)

@Composable
fun VinniTrackerTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }

    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content,
  )
}
