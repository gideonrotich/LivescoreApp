package com.example.livescore.presentation.screens.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

@Composable
fun LiveMatchItem(match: DataModel, onItemClicked: (match: DataModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onItemClicked(match) },
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp,
        backgroundColor = colorResource(id = R.color.purple)
    ) {
        Box(
            modifier = Modifier
                .height(250.dp)
                .width(300.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(
                        text = "Premier league",
                        fontSize = 22.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(
                        text = "Week 10",
                        fontSize = 18.sp,
                        color = Color.LightGray,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(start = 20.dp)
                    ) {

                        Row {
                            Spacer(modifier = Modifier.width(8.dp))
                            val image: Painter = rememberImagePainter(data = match.home_team?.logo)
                            Image(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                painter = image,
                                alignment = Alignment.Center,
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "${match.home_team?.name}",
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "     Home",
                            style = MaterialTheme.typography.body1,
                            color = Color.LightGray,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .align(alignment = CenterVertically)
                    ) {
                        Row() {
                            val imaged: Painter =
                                rememberImagePainter(data = R.drawable.premier_logo)

                            Image(
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(80.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                painter = imaged,
                                alignment = Alignment.Center,
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                        }

                        Column() {

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = " ${match.stats?.home_score}" + " - ",
                                    style = MaterialTheme.typography.h1,
                                    color = Color.White,
                                    fontSize = 52.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                                Text(
                                    text = "${match.stats?.away_score}",
                                    style = MaterialTheme.typography.body1,
                                    color = Color.White,
                                    fontSize = 52.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }

                            Row(modifier = Modifier.padding(36.dp, 1.dp, 1.dp, 1.dp)) {
                                Box(
                                    modifier =
                                    Modifier
                                        .border(
                                            width = 1.dp,
                                            color = colorResource(id = R.color.pink),
                                            shape = RoundedCornerShape(16.dp)
                                        )
                                        .padding(10.dp)
                                        .height(16.dp)

                                ) {
                                    match.status?.let {
                                        Text(
                                            text = "FT",
                                            color = Color.White,
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.body2
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(end = 12.dp)
                    ) {

                        Row {
                            Spacer(modifier = Modifier.width(8.dp))
                            val imageTwo: Painter = rememberImagePainter(data = match.away_team?.logo)
                            Image(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                painter = imageTwo,
                                alignment = Alignment.Center,
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "${match.away_team?.name}",
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "     Away",
                            style = MaterialTheme.typography.body1,
                            color = Color.LightGray,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
