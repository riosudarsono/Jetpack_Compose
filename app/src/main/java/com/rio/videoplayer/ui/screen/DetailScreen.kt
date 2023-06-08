package com.rio.videoplayer.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun DetailScreen(
    navController: NavController,
    id: Int?,
    data: String?,
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(text = "Detail Screen $id $data")
            Text(text = "Back Home", modifier = Modifier.clickable {
                navController.popBackStack()
            }, color = Color.Blue)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetail(){
    DetailScreen(
        navController = rememberNavController(),
        id = 0,
        data = ""
    )
}