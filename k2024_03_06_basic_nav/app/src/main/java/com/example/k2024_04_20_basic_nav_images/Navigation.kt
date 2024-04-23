package com.example.k2024_04_20_basic_nav_images


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.k2024_04_20_basic_nav_images.screens.MainScreen
import com.example.k2024_04_20_basic_nav_images.screens.LeftScreen
import com.example.k2024_04_20_basic_nav_images.screens.RightScreen
import com.example.k2024_04_20_basic_nav_images.screens.ScreenRoutes
import com.example.k2024_04_20_basic_nav_images.timers.LeftScreenViewModel
import com.example.k2024_04_20_basic_nav_images.timers.RightScreenViewModel

@Composable
fun Navigation(leftScreenViewModel: LeftScreenViewModel, rightScreenViewModel: RightScreenViewModel) {
    val navController = rememberNavController()
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

