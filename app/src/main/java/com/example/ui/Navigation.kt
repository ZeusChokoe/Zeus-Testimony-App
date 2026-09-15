package com.example.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ReaderScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToVolume = { volumeId -> navController.navigate("reader/$volumeId") }
            )
        }
        composable("reader/{volumeId}") { backStackEntry ->
            val volumeId = backStackEntry.arguments?.getString("volumeId") ?: "vol_1"
            ReaderScreen(
                volumeId = volumeId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
