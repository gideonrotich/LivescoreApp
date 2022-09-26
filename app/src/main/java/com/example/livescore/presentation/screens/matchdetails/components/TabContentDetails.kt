package com.example.livescore.presentation.screens.matchdetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.livescore.R
import com.example.livescore.data.remote.dto.matchdetails.MatchEvent
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
                                    Text(text = "goal " + item.player_name)
                                    Text(text = "Assist by " + item.related_player_name)
                                    Spacer(modifier = Modifier.height(20.dp))

                                } else {
                                    Text(text = "" + item.type)
                                    Text(text = "" + item.player_name)
                                    Spacer(modifier = Modifier.height(20.dp))
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
                                    Text(text = "imework " + item.player_name)
                                    Text(text = "imework " + item.related_player_name)
                                    Spacer(modifier = Modifier.height(20.dp))

                                } else {
                                    Text(text = "imework" + item.type)
                                    Text(text = "" + item.player_name)
                                    Spacer(modifier = Modifier.height(20.dp))
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
fun TabScreenTwo(tabName: String) {
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