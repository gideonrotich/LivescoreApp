package com.example.livescore.presentation.screens.matchdetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.livescore.R
import com.example.livescore.data.remote.dto.matchdetails.Lineup
import com.example.livescore.data.remote.dto.matchdetails.MatchEvent
import com.example.livescore.data.remote.dto.matchdetails.Player
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.ui.theme.TabColorTwo


@Composable
fun TabScreenOne(tabName: String, match: List<MatchEvent>, one: Int, two: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(6.dp),
            elevation = 3.dp,
        ) {

            LazyColumn(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxSize()

            ) {
                items(items = match) { item ->

                    if (item.team_id == one) {

                        Column(modifier = Modifier.fillMaxSize()) {
                            Column(modifier = Modifier.align(Alignment.Start)) {
                                if (item.type == "goal") {
                                    Row(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )

                                        Spacer(modifier = Modifier.width(10.dp))

                                        Image(
                                            painter = painterResource(id = R.drawable.reggae),
                                            modifier = Modifier
                                                .height(38.dp)
                                                .width(38.dp)
                                                .padding(10.dp)
                                                .align(Alignment.CenterVertically),
                                            contentDescription = "",

                                            )

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                                            Text(
                                                text = item.player_name + "(${item.result})",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 14.sp
                                            )
                                            if (item.related_player_name != null) {
                                                Text(
                                                    text = "Assist by " + item.related_player_name,
                                                    color = Color.Gray,
                                                    fontSize = 12.sp
                                                )
                                            }
                                        }

                                    }

                                }
                                if (item.type == "substitution") {
                                    Row(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Column {
                                            Card(
                                                shape = RoundedCornerShape(100.dp),
                                                modifier = Modifier.padding(top = 4.dp)
                                            ) {
                                                Column {
                                                    Row(
                                                        modifier = Modifier
                                                            .size(14.dp)
                                                            .background(Color.Green)
                                                    ) {
                                                        Image(
                                                            imageVector = Icons.Default.ArrowForward,
                                                            modifier = Modifier
                                                                .fillMaxSize()
                                                                .padding(2.dp)
                                                                .align(Alignment.CenterVertically),
                                                            contentDescription = "",
                                                            colorFilter = ColorFilter.tint(Color.White)
                                                        )

                                                    }

                                                }
                                            }

                                            Spacer(modifier = Modifier.height(1.dp))

                                            Card(
                                                shape = RoundedCornerShape(100.dp),
                                                modifier = Modifier
                                            ) {
                                                Column {
                                                    Row(
                                                        modifier = Modifier
                                                            .size(14.dp)
                                                            .background(Color.Red)
                                                    ) {
                                                        Image(
                                                            imageVector = Icons.Default.ArrowBack,
                                                            modifier = Modifier
                                                                .fillMaxSize()
                                                                .padding(2.dp)
                                                                .align(Alignment.CenterVertically),
                                                            contentDescription = "",
                                                            colorFilter = ColorFilter.tint(Color.White)
                                                        )

                                                    }

                                                }
                                            }

                                        }
                                        Spacer(modifier = Modifier.width(20.dp))

                                        Column {
                                            Text(
                                                text = item.related_player_name,
                                                fontSize = 14.sp,
                                                color = Color.Green
                                            )
                                            Spacer(modifier = Modifier.height(1.dp))

                                            Text(
                                                text = item.player_name,
                                                fontSize = 14.sp,
                                                color = Color.Red
                                            )
                                        }


                                    }
                                }

                                if (item.type == "yellowcard") {
                                    Row(
                                        modifier = Modifier.padding(
                                            start = 16.dp,
                                            top = 8.dp,
                                            bottom = 8.dp
                                        )
                                    ) {
                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Card(
                                            modifier = Modifier
                                                .align(Alignment.CenterVertically)
                                                .height(16.dp)
                                                .width(12.dp)
                                                .background(
                                                    Color.Yellow
                                                )
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(Color.Yellow)
                                            )

                                        }

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Text(
                                            text = item.player_name,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )
                                    }
                                }

                                if (item.type == "injury") {
                                    Row(
                                        modifier = Modifier.padding(
                                            start = 16.dp,
                                            top = 8.dp,
                                            bottom = 8.dp
                                        )
                                    ) {
                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Image(
                                            imageVector = Icons.Default.Warning,
                                            modifier = Modifier
                                                .size(22.dp)
                                                .padding(2.dp)
                                                .align(Alignment.CenterVertically),
                                            contentDescription = "",
                                            colorFilter = ColorFilter.tint(Color.Red)
                                        )

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Text(
                                            text = item.player_name,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )

                                    }
                                }

                                if (item.type == "back from injury") {
                                    Row(
                                        modifier = Modifier.padding(
                                            start = 16.dp,
                                            top = 8.dp,
                                            bottom = 8.dp
                                        )
                                    ) {
                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Image(
                                            imageVector = Icons.Default.Add,
                                            modifier = Modifier
                                                .size(22.dp)
                                                .padding(2.dp)
                                                .align(Alignment.CenterVertically),
                                            contentDescription = "",
                                            colorFilter = ColorFilter.tint(Color.Green)
                                        )

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Text(
                                            text = item.player_name,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )

                                    }
                                }

                            }

                        }

                    }

                    if (item.team_id == two) {

                        Column(
                            modifier = Modifier
                                .align(End)
                                .fillMaxSize()
                        ) {
                            Column(modifier = Modifier.align(Alignment.End)) {
                                if (item.type == "goal") {
                                    Row(modifier = Modifier.padding(end = 16.dp, top = 8.dp)) {


                                        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                                            Text(
                                                text = item.player_name + "(${item.result})",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 14.sp
                                            )
                                            if (item.related_player_name != null) {
                                                Text(
                                                    text = "Assist by " + item.related_player_name,
                                                    color = Color.Gray,
                                                    fontSize = 12.sp
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Image(
                                            painter = painterResource(id = R.drawable.reggae),
                                            modifier = Modifier
                                                .height(38.dp)
                                                .width(38.dp)
                                                .padding(10.dp)
                                                .align(Alignment.CenterVertically),
                                            contentDescription = "",

                                            )

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )

                                    }

                                }

                                if (item.type == "substitution") {

                                    Row(modifier = Modifier.padding(end = 16.dp, top = 8.dp)) {

                                        Column {
                                            Text(
                                                text = item.related_player_name,
                                                fontSize = 14.sp,
                                                color = Color.Green
                                            )
                                            Spacer(modifier = Modifier.height(1.dp))

                                            Text(
                                                text = item.player_name,
                                                fontSize = 14.sp,
                                                color = Color.Red
                                            )
                                        }

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Column {
                                            Card(
                                                shape = RoundedCornerShape(100.dp),
                                                modifier = Modifier.padding(top = 4.dp)
                                            ) {
                                                Column {
                                                    Row(
                                                        modifier = Modifier
                                                            .size(14.dp)
                                                            .background(Color.Green)
                                                    ) {
                                                        Image(
                                                            imageVector = Icons.Default.ArrowBack,
                                                            modifier = Modifier
                                                                .fillMaxSize()
                                                                .padding(2.dp)
                                                                .align(Alignment.CenterVertically),
                                                            contentDescription = "",
                                                            colorFilter = ColorFilter.tint(Color.White)
                                                        )

                                                    }

                                                }
                                            }

                                            Spacer(modifier = Modifier.height(1.dp))

                                            Card(
                                                shape = RoundedCornerShape(100.dp),
                                                modifier = Modifier
                                            ) {
                                                Column {
                                                    Row(
                                                        modifier = Modifier
                                                            .size(14.dp)
                                                            .background(Color.Red)
                                                    ) {
                                                        Image(
                                                            imageVector = Icons.Default.ArrowForward,
                                                            modifier = Modifier
                                                                .fillMaxSize()
                                                                .padding(2.dp)
                                                                .align(Alignment.CenterVertically),
                                                            contentDescription = "",
                                                            colorFilter = ColorFilter.tint(Color.White)
                                                        )

                                                    }

                                                }
                                            }

                                        }

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )


                                    }


                                }
                                if (item.type == "yellowcard") {
                                    Row(
                                        modifier = Modifier.padding(
                                            end = 16.dp,
                                            top = 8.dp,
                                            bottom = 8.dp
                                        )
                                    ) {
                                        Text(
                                            text = item.player_name,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )

                                        Spacer(modifier = Modifier.width(20.dp))


                                        Card(
                                            modifier = Modifier
                                                .align(Alignment.CenterVertically)
                                                .height(16.dp)
                                                .width(12.dp)
                                                .background(
                                                    Color.Yellow
                                                )
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(Color.Yellow)
                                            )

                                        }

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )


                                    }
                                }
                                if (item.type == "injury") {
                                    Row(
                                        modifier = Modifier.padding(
                                            end = 16.dp,
                                            top = 8.dp,
                                            bottom = 8.dp
                                        )
                                    ) {

                                        Text(
                                            text = item.player_name,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Image(
                                            imageVector = Icons.Default.Warning,
                                            modifier = Modifier
                                                .size(22.dp)
                                                .padding(2.dp)
                                                .align(Alignment.CenterVertically),
                                            contentDescription = "",
                                            colorFilter = ColorFilter.tint(Color.Red)
                                        )

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )


                                    }
                                }
                                if (item.type == "back from injury") {
                                    Row(
                                        modifier = Modifier.padding(
                                            end = 16.dp,
                                            top = 8.dp,
                                            bottom = 8.dp
                                        )
                                    ) {

                                        Text(
                                            text = item.player_name,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Image(
                                            imageVector = Icons.Default.Add,
                                            modifier = Modifier
                                                .size(22.dp)
                                                .padding(2.dp)
                                                .align(Alignment.CenterVertically),
                                            contentDescription = "",
                                            colorFilter = ColorFilter.tint(Color.Green)
                                        )

                                        Spacer(modifier = Modifier.width(18.dp))

                                        Text(
                                            text = item.minute.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )


                                    }
                                }

                            }

                        }

                    }

                }
            }
        }
    }
}

@Composable
fun TabScreenTwo(tabName: String, lineup: List<Lineup>, one: Int, two: Int) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(6.dp),
        elevation = 3.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            LazyRow(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(items = lineup) { item ->

                    if (item.team_id == one) {

                        LazyColumn(modifier = Modifier.padding(start = 12.dp)) {

                            items(items = item.players) { items ->
                                Column {


                                    Row(modifier = Modifier.padding(top = 16.dp)) {
                                        Card(
                                            shape = RoundedCornerShape(100.dp),
                                            modifier = Modifier.align(CenterVertically)
                                        ) {
                                            Column {
                                                Row(
                                                    modifier = Modifier
                                                        .size(20.dp)
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.reggae),
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .align(Alignment.CenterVertically),
                                                        contentDescription = "",
                                                    )

                                                }

                                            }
                                        }
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(
                                            text = items.lastname,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Text(
                                            text = items.detailed.number.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )


                                    }

                                }
                            }
                        }
                    }


                    if (item.team_id == two) {
                        LazyColumn(
                            modifier = Modifier
                                .align(End)
                                .padding(end = 12.dp)
                                .fillMaxSize()
                        ) {
                            items(items = item.players) { items ->
                                Column(
                                    modifier = Modifier
                                        .align(End)
                                        .fillMaxSize()
                                ) {


                                    Row(modifier = Modifier.padding(top = 16.dp)) {
                                        Card(
                                            shape = RoundedCornerShape(100.dp),
                                            modifier = Modifier.align(CenterVertically)
                                        ) {
                                            Column {
                                                Row(
                                                    modifier = Modifier
                                                        .size(20.dp)
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.reggae),
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .align(Alignment.CenterVertically),
                                                        contentDescription = "",
                                                    )

                                                }

                                            }
                                        }
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(
                                            text = items.lastname,
                                            fontSize = 14.sp,
                                            modifier = Modifier.align(CenterVertically)
                                        )

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Text(
                                            text = items.detailed.number.toString(),
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            fontSize = 15.sp
                                        )


                                    }

                                }
                            }
                        }
                    }

                }
            }

        }
    }


}

@Composable
fun TabScreenThree(tabName: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = tabName,
            style = MaterialTheme.typography.h5,
            color = TabColorTwo,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )

    }
}