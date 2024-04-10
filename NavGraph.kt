package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class Screens (val route: String){
    data object HomeScreen: Screens("home_screen")
    data object DetailScreen: Screens("detail_screen")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route =  Screens.HomeScreen.route){
            HomeScreen(rememberNavController())
        }
        composable(route = Screens.DetailScreen.route){
            DetailScreen(rememberNavController())
        }
    }
}

