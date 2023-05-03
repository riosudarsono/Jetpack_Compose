package com.rio.videoplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rio.videoplayer.ui.theme.Typography
import com.rio.videoplayer.ui.theme.VideoPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = MaterialTheme.typography.bodyMedium.fontSize
    )
}

@Composable
fun TextLocal() {
    Text(
        text = stringResource(id = R.string.app_name),
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CusText(text: String) {
    Surface(
        modifier = Modifier
            .width(100.dp)
            .padding(bottom = 16.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = "Custom Text $text",
            style = Typography.titleLarge,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize
        )
    }

}

@Composable
fun MainView() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextLocal()
        Column {
            Greeting("Android")
            CusText(text = "Rio")
            CusText(text = "Rio")
            CusText(text = "Rio")
        }

        Row {
            Greeting("Android")
            CusText(text = "Rio")
            CusText(text = "Rio")
            CusText(text = "Rio")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VideoPlayerTheme {
        MainView()
    }
}