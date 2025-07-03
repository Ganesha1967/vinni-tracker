package com.example.vinni_tracker.presentation.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController, modifier: Modifier = Modifier) {
  NavigationBar(
    containerColor = Color(0xFF024A6B),
    modifier = modifier.height(86.dp),
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Constants.BottomNavItems.forEach { navItem ->

      NavigationBarItem(
        selected = currentRoute == navItem.route,
        onClick = {
          navController.navigate(navItem.route)
        },
        icon = {
          Icon(painter = painterResource(id = navItem.icon), contentDescription = navItem.label)
        },
        label = {
          Text(text = navItem.label)
        },
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
          selectedIconColor = Color(0xFFD1F0FF),
          selectedTextColor = Color(0xFFD1F0FF),
          unselectedIconColor = Color(0xFFFFE7BF),
//                    unselectedTextColor = Color(0xFFFFE7BF),
          indicatorColor = Color(0xFF026D9E),
        ),
      )
    }
  }
}
