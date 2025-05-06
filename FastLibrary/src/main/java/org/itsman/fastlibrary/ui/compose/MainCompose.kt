package org.itsman.fastlibrary.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.itsman.fastlibrary.R
import org.itsman.fastlibrary.ui.compose.theme.Purple80
import org.itsman.fastlibrary.ui.viewmodel.MainActivityVM


val params = Modifier
    .padding(10.dp)
    .fillMaxWidth(1f)
    .background(color = Color.Green)


@Composable
fun Show(name: String = "kevin", model: MainActivityVM): Unit {
    var data by remember {
        mutableStateOf(1)
    }
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
            Text(
                text = name + data,
                color = Color(0xffff0090),
                fontSize = TextUnit.Unspecified,
                modifier = Modifier.size(140.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green, fontSize = TextUnit(20F, TextUnitType.Sp)
                        )
                    ) {
                        append("HH")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xff00B277), fontSize = TextUnit(15F, TextUnitType.Sp)
                        )
                    ) {
                        append("123")
                    }
                    append(model.stat.value)
                },
                overflow = TextOverflow.Visible,
                maxLines = 1,
                fontSize = TextUnit(10F, TextUnitType.Sp)
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

data class Message(val name: String, val body: String)

@Composable
fun Car(msg: Message) {
    var aa = rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(15.dp)
            .background(Color.White, shape = RoundedCornerShape(15.dp))
            .padding(5.dp),
    ) {
        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth(1f)
                .padding(horizontal = 20.dp)
                .paint(painter =painterResource(R.drawable.asdf) )
                .clickable {
                    aa.value = !aa.value
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.asdf),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(if (aa.value) 300.dp else 30.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Column() {
                Text(msg.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Divider(color = Color.Black, modifier = Modifier.width(40.dp))
                Text(msg.body)
            }
        }
    }
}

//fun Modifier.firstBaselineToTop() = Modifier.layout { measureable, constraints ->
//    val parcel = measureable.measure(constraints)
//
//    return@layout
//}

@Preview
@Composable
fun Test() {
    val msgList = mutableListOf<Message>()
    for (i in 1..20) {
        msgList.add(Message("$i$i$i", "i'm Car"))
    }
    LazyColumn(
        modifier = Modifier.background(Purple80)
    ) {
        items(msgList) { i ->
            Car(i)
        }
    }
}