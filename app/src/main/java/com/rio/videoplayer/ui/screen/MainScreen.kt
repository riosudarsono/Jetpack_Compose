@file:OptIn(ExperimentalMaterial3Api::class)

package com.rio.videoplayer.ui.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rio.videoplayer.CustomItem
import com.rio.videoplayer.R
import com.rio.videoplayer.Screen
import com.rio.videoplayer.repository.PersonRepository
import com.rio.videoplayer.ui.theme.Typography

fun onClick(context: Context, text: String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
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
        Column {
            Text(
                text = "Custom Text $text",
                style = Typography.titleLarge,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )

            Text( buildAnnotatedString {
                append("A")
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.error
                    )
                ){
                    append("B")
                }
            })
        }


    }
}

@Composable
fun selectContent(){
    SelectionContainer {
        Column {
            Text(text = "Select Text")
            DisableSelection {
                Text(text = "Cannot Select Text")
            }
            Text(text = "Select Text")
        }
    }
}

@Composable
fun textField(){
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        placeholder = {
            Text("Masukkan Email Anda", fontSize = 20.sp)
        },
        textStyle = TextStyle(fontSize = 20.sp),
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
            Icon(Icons.Rounded.Email, "", tint = Color.Gray)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun MainScreen(
    navControler: NavController
) {
    val repo = PersonRepository()
    val listData = repo.getAllDAta()

    Column (
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextLocal()
        Column {
            Greeting("Android")
            CusText(text = "Rio")
        }

        Row {
            Greeting("Android")
            CusText(text = "Rio")
        }
        selectContent()
        textField()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                LazyColumn(
                    contentPadding = PaddingValues(all = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    itemsIndexed(items = listData){ i, item ->
                        Log.d("MainActivity", i.toString())
                        Surface(modifier = Modifier.clickable {
//                                    onClick(baseContext, "${item.firstName} ${item.lastName}")
                            navControler.navigate(route = Screen.Detail.passIDAndData(item.id, item.firstName))
                        }) {
                            CustomItem(person = item)
                            Divider(color = Color.LightGray, thickness = 0.5.dp)
                        }

                    }
                }
            }
        }
    }
}