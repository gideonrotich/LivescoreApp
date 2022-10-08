package com.example.livescore.presentation.screens.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.livescore.R
import com.example.livescore.domain.models.DataModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun UpcomingMatchesItem(match: DataModel, onItemClicked: (match: DataModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 5.dp)
            .clickable { onItemClicked(match) },
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
        backgroundColor = White
    ) {
        Box(modifier = Modifier.height(68.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 10.dp)
                    .align(alignment = Alignment.Center),
            ) {
                Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = "${match.home_team?.name}",
                        style = MaterialTheme.typography.body1,
                        color = Black,
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                val image: Painter = rememberImagePainter(data = match.home_team?.logo)

                Image(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    painter = image,
                    alignment = Alignment.Center,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp))
                val month = getMatchDayAndMonth(match.match_start!!)
                val time = getMatchTime(match.match_start)
                Column {
                    Text(
                        text = "$time",
                        style = MaterialTheme.typography.body1,
                        color = colorResource(id = R.color.black),
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "  $month",
                        style = MaterialTheme.typography.body1,
                        color = colorResource(id = R.color.pink),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))
                val imageone: Painter = rememberImagePainter(data = match.away_team?.logo)

                Image(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    painter = imageone,
                    alignment = Alignment.Center,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(3.dp))
                Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = "${match.away_team?.name}",
                        style = MaterialTheme.typography.body1,
                        color = Black,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

fun getMatchDayAndMonth(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val formatter = SimpleDateFormat("d MMM", Locale.ENGLISH)
    return date.let { it -> parser.parse(it)?.let { formatter.format(it) } }
}

fun getMatchTime(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val formatter = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
    return date.let { it -> parser.parse(it)?.let { formatter.format(it) } }
}
