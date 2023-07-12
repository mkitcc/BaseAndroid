package org.itsman.baseandroid.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.itsman.baseandroid.R

@Composable
fun Show(name: String, list:List<String>): Unit {
    val params = Modifier
        .padding(22.dp)
        .background(color = Color.Green)
    LazyColumn(
        params,
    ) {
        for (i in 0..10){
            item {
                item(name = "Compose课程第${i+1}课,快来学习吧～")
            }
        }
    }
}

@Composable
fun item(name: String) {
    Row(
        Modifier
            .padding(10.dp)
            .background(color = Color.Magenta)
    ) {
        Text(text = name, textAlign = TextAlign.End)
        Image(
            painter = painterResource(id = R.drawable.asdf),
            contentDescription = null
        )
    }
    Divider(color = Color.Black)
}

@Composable
fun Counter(){
    var number by remember {
        mutableStateOf(0)
    }
    Column {
        Text(text = "当前值:$number")
        Button(onClick = {number++}) {
            Text(text = "add")
        }
    }
}