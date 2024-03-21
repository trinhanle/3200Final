package com.example.k2024_03_06_basic_nav


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.k2024_03_06_basic_nav.screens.MainScreen
import com.example.k2024_03_06_basic_nav.screens.LeftScreen
import com.example.k2024_03_06_basic_nav.screens.RightScreen
import com.example.k2024_03_06_basic_nav.screens.ScreenRoutes
import com.example.k2024_03_06_basic_nav.timers.LeftScreenViewModel
import com.example.k2024_03_06_basic_nav.timers.RightScreenViewModel

@Composable
fun Navigation(leftScreenViewModel: LeftScreenViewModel, rightScreenViewModel: RightScreenViewModel) {
    var navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = ScreenRoutes.MainScreen.route) {
            composable(route = ScreenRoutes.MainScreen.route) {
                MainScreen(navController = navController)
            }
            composable(route = ScreenRoutes.LeftScreen.route) {
                LeftScreen(name = "LEFT", leftScreenViewModel)
            }
            composable(route = ScreenRoutes.RightScreen.route) {
                RightScreen(name = "RIGHT", rightScreenViewModel)
            }
    }
}

