package com.rio.videoplayer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rio.videoplayer.repository.PersonRepository
import com.rio.videoplayer.ui.screen.MainScreen
import com.rio.videoplayer.ui.screen.onClick
import com.rio.videoplayer.ui.theme.VideoPlayerTheme

class MainActivity : ComponentActivity() {

    lateinit var navControler: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoPlayerTheme {
                navControler = rememberNavController()
                SetupNavGraph(navController = navControler)
                // A surface container using the 'background' color from the theme
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VideoPlayerTheme {
        MainScreen(
            navControler = rememberNavController()
        )
    }
}