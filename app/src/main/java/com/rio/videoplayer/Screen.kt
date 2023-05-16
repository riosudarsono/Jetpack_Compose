package com.rio.videoplayer

sealed class Screen(val route: String) {
    object Main: Screen(route = "main_screen")
    object Second: Screen(route = "second_screen")
    object Detail: Screen(route = "detail_screen")
}
