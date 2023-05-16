package com.rio.videoplayer

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rio.videoplayer.ui.screen.DetailScreen
import com.rio.videoplayer.ui.screen.MainScreen
import com.rio.videoplayer.ui.screen.SecondScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Main.route){
            MainScreen(navControler = navController)
        }
        composable(route = Screen.Detail.route){
            DetailScreen(navController = navController)
        }
        composable(route = Screen.Second.route){
            SecondScreen()
        }
    }
}