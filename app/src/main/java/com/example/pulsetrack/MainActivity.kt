package com.example.pulsetrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pulsetrack.navigation.AnalyticsRoute
import com.example.pulsetrack.navigation.DashboardRoute
import com.example.pulsetrack.navigation.FitTrackerNavHost
import com.example.pulsetrack.navigation.SettingsRoute
import com.example.pulsetrack.navigation.SleepRoute
import com.example.pulsetrack.navigation.TopLevelDestination
import com.example.pulsetrack.navigation.WorkoutRoute
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PulseTrackTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            TOP_LEVEL_DESTINATIONS.forEach { destination ->
                                val isSelected = currentDestination?.hierarchy?.any {
                                    it.hasRoute(destination.route::class)
                                } == true

                                NavigationBarItem(
                                    selected = isSelected,
                                    onClick = {
                                        navController.navigate(destination.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            destination.icon,
                                            contentDescription = destination.label
                                        )
                                    },
                                    label = { Text(destination.label) }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    FitTrackerNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }
}

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(DashboardRoute, Icons.Default.Home, "Home"),
    TopLevelDestination(WorkoutRoute, Icons.Default.PlayArrow, "Workout"),
    TopLevelDestination(SleepRoute, Icons.Default.Bedtime, "Sleep"),
    TopLevelDestination(AnalyticsRoute, Icons.Default.BarChart, "Analytics"),
    TopLevelDestination(SettingsRoute, Icons.Default.Settings, "Settings"),
)

@Composable
fun PulseTrackTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}