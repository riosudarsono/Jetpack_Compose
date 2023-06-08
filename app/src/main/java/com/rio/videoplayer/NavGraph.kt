package com.rio.videoplayer

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(KEY_ID){ type = NavType.IntType },
                navArgument(KEY_DATA){ type = NavType.StringType }
            )

        ){
            Log.d("Args", it.arguments?.getInt(KEY_ID).toString())
            DetailScreen(
                navController = navController,
                id = it.arguments?.getInt(KEY_ID),
                data = it.arguments?.getString(KEY_DATA))
        }
        composable(route = Screen.Second.route){
            SecondScreen()
        }
    }
}