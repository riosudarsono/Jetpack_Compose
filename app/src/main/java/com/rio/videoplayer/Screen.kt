package com.rio.videoplayer

const val KEY_ID = "id"
const val KEY_DATA = "data"
sealed class Screen(val route: String) {
    object Main: Screen(route = "main_screen")
    object Second: Screen(route = "second_screen")
    object Detail: Screen(route = "detail_screen/{$KEY_ID}/{$KEY_DATA}") {
        fun passIDAndData(id: Int, data: String): String {
//            return  this.route.replace(oldValue = "{$KEY_ID}", newValue = id.toString())
            return "detail_screen/$id/$data"
        }
    }
}
