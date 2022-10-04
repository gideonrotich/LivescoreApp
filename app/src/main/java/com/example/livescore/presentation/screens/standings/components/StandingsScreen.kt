package com.example.livescore.presentation.screens.standings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.livescore.R
import com.example.livescore.presentation.screens.standings.StandingsViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun StandingScreen(
    viewModel: StandingsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val isRefreshing by viewModel.isRefresh.collectAsState()

    Box(
        modifier = Modifier
            // .background()
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Column {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
                onRefresh = { viewModel.refresh() }
            ) {

                Column() {

                    Image(
                        painter = painterResource(id = R.drawable.banner), contentDescription = "",
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    ) {
                        Row(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "Pos",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                            Spacer(modifier = Modifier.width(23.dp))
                            Text(
                                text = "Club",
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(30.dp))
                            Text(
                                text = "P",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "W",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "D",
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "L",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "GD",
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "Pts",
                                fontSize = 14.sp
                            )
                        }
                    }

                    LazyColumn() {
                        items(state.standings) { standings ->
                            StandingsListItem(
                                standings = standings,
                            )
                        }
                    }
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colorResource(
                    id = R.color.purple
                )
            )
        }
    }
}
