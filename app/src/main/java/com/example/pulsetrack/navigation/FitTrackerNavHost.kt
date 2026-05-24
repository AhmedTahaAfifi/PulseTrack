package com.example.pulsetrack.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

@Composable
fun FitTrackerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = DashboardRoute,
    ) {
        composable<DashboardRoute> {
            PlaceholderScreen("Dashboard Screen")
        }
        composable<WorkoutRoute> {
            PlaceholderScreen("Workout Screen")
        }
        composable<SleepRoute> {
            PlaceholderScreen("Sleep Screen")
        }
        composable<AnalyticsRoute> {
            PlaceholderScreen("Analytics Screen")
        }
        composable<SettingsRoute> {
            PlaceholderScreen("Settings Screen")
        }
    }
}

@Composable
fun PlaceholderScreen(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name)
    }
}