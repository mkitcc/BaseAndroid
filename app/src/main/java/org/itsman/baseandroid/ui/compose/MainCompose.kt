package org.itsman.baseandroid.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.itsman.baseandroid.R

@Composable
fun Show(name: String, onClick: () -> Unit): Unit {
    val params = Modifier
        .clickable(onClick = onClick)
        .padding(22.dp)
        .background(color = Color.Green)
    Column(
        params, Arrangement.Bottom, Alignment.End
    ) {
        Text(text = "hello world", Modifier.padding(10.dp))
        Text(text = "hello world", Modifier.padding(10.dp))
        Text(text = "hello world", Modifier.padding(10.dp))
        Text(text = "hello world", Modifier.padding(10.dp))
        Divider(color = Color.Black)
        Image(
            painter = painterResource(id = R.drawable.asdf),
            contentDescription = null
        )
    }
}


fun Test() {

}

open class A(val a: (Int) -> Boolean) {

}
