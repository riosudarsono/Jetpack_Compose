package com.rio.videoplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rio.videoplayer.model.Person
import com.rio.videoplayer.ui.theme.Typography
import com.rio.videoplayer.ui.theme.VideoPlayerTheme

@Composable
fun CustomItem(person: Person){
    Row(modifier = Modifier
        .background(Color.Transparent)
        .fillMaxWidth()
        .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = Typography.titleSmall.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = Typography.titleSmall.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = Typography.titleSmall.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview(){
    CustomItem(
        person = Person(
            id = 1,
            firstName = "Rio",
            lastName = "Sudarsono",
            age = 28)
    )
}