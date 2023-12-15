package org.itsman.baseandroid.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import org.itsman.baseandroid.R
import org.itsman.fastlibrary.tools.toast

@Preview(showBackground = true, name = "Main", showSystemUi = true)
@Composable
fun Show(name: String = "kevin"): Unit {
    var data by remember {
        mutableStateOf(1)
    }
    val params = Modifier
        .padding(10.dp)
        .fillMaxWidth(1f)
        .background(color = Color.Green)
    Column {
        Box(modifier = params) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .clickable { data++ },
                painter = painterResource(id = R.drawable.asdf),
                contentDescription = null
            )
        }
        Row {
            Text(text = name + data,
                color = Color(android.graphics.Color.parseColor("#009900")),
                fontSize = TextUnit.Unspecified,
                modifier = Modifier.size(140.dp)
            )
            Text(
                text = "asdfasdfasdfweijasldfijweija;sldfijweijsdfkjfiesdkfjeiajsdlfiwejiasdfe",
                overflow = TextOverflow.Visible,
                maxLines = 1
            )
        }
    }

}

@Composable
fun Item(name: String) {
    Row(
        Modifier
            .padding(10.dp)
            .background(color = Color.Magenta)
    ) {
        Text(text = name, textAlign = TextAlign.End)
        Image(
            painter = painterResource(id = R.drawable.asdf),
            contentDescription = null,
            Modifier.clickable { },
        )
    }
    Divider(color = Color.Black)
}

@Composable
fun Counter(number: Int = 0) {
    var number by remember {
        mutableStateOf(number)
    }
    Column {
        Text(text = "当前值:$number")
        Button(onClick = { number++ }) {
            Text(text = "add")
        }
    }
}