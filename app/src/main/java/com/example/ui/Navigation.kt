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
                onNavigateToOldTestament = { navController.navigate("reader/old") },
                onNavigateToNewTestament = { navController.navigate("reader/new") }
            )
        }
        composable("reader/{volume}") { backStackEntry ->
            val volume = backStackEntry.arguments?.getString("volume") ?: "old"
            ReaderScreen(
                volume = volume,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
