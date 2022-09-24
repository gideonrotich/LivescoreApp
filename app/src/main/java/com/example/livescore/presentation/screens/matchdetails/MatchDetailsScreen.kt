package com.example.livescore.presentation.screens.matchdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.livescore.data.remote.dto.matchdetails.MatchEvent
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.presentation.Screen
import com.example.livescore.presentation.screens.matchdetails.components.TabScreenOne
import com.example.livescore.presentation.screens.matchdetails.components.TabScreenThree
import com.example.livescore.presentation.screens.matchdetails.components.TabScreenTwo
import com.example.livescore.presentation.screens.matches.components.LiveMatchItem
import com.example.livescore.presentation.screens.matches.components.MatchesViewModel
import com.example.livescore.ui.theme.TabColorOne
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MatchDetailsScreen(
    matchdetailsViewModel: MatchDetailsViewModel = hiltViewModel()
) {
    val matchesState = matchdetailsViewModel.state.value
    val context = LocalContext.current

    Column {
        matchesState.matchdetails?.let { match ->


            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = com.example.livescore.R.color.purple))
            ) {

                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        item {
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
                                        .fillMaxSize()
                                        .padding(top = 10.dp)
                                ) {
                                    Text(
                                        text = "Week 10",
                                        fontSize = 18.sp,
                                        color = Color.LightGray,
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .fillMaxSize().padding(start = 30.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .padding(start = 20.dp)
                                    ) {

                                        Row {
                                            Spacer(modifier = Modifier.width(8.dp))
                                            val image: Painter =
                                                rememberImagePainter(data = match.home_team?.logo)
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
                                            .align(alignment = Alignment.CenterVertically)
                                    ) {
                                        Row() {
                                            val imaged: Painter =
                                                rememberImagePainter(data = com.example.livescore.R.drawable.premier_logo)

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
                                                    text = " ${match.stats?.ft_score}",
                                                    style = MaterialTheme.typography.h1,
                                                    color = Color.White,
                                                    fontSize = 52.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(top = 10.dp)
                                                )

                                            }

                                            Row(
                                                modifier = Modifier.padding(
                                                    36.dp,
                                                    1.dp,
                                                    1.dp,
                                                    1.dp
                                                )
                                            ) {
                                                Box(
                                                    modifier =
                                                    Modifier
                                                        .border(
                                                            width = 1.dp,
                                                            color = colorResource(id = com.example.livescore.R.color.pink),
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
                                    Column(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .padding(end = 12.dp)
                                    ) {
                                        Row() {
                                            Spacer(modifier = Modifier.width(8.dp))
                                            val imagetwo: Painter =
                                                rememberImagePainter(data = match.away_team?.logo)

                                            Image(
                                                modifier = Modifier
                                                    .height(50.dp)
                                                    .width(50.dp)
                                                    .clip(RoundedCornerShape(8.dp)),
                                                painter = imagetwo,
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


                if (matchesState.error.isNotBlank()) {
                    Text(
                        text = matchesState.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (matchesState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            TabScreen(match.match_events!!)
        }
    }

}


@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "TabLayout", color = Color.White) },
        backgroundColor = TabColorOne,

        )
}

@ExperimentalPagerApi
@Composable
fun TabScreen(match:List<MatchEvent>) {
    val pagerState = rememberPagerState(pageCount = 4)

    Column(
        modifier = Modifier.background(Color.White)
    )
    {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState,match)

    }

}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val list = listOf("Events", "Lineup", "Stats", "Table")

    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage,
        backgroundColor = colorResource(id = com.example.livescore.R.color.purple),
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 3.dp,
                color = Color.White
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                    .width(20.dp),
                height = 3.dp,
                color = Color.Red
            )

        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        text = list[index],
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },

                )
        }

    }


}


@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState,match: List<MatchEvent>) {

    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> TabScreenOne(tabName = "This is a Home Tab Layout", match = match)
            1 -> TabScreenTwo(tabName = "This is a Market Tab Layout")
            2 -> TabScreenThree(tabName = "This is a Films Tab Layout")
            3 -> TabScreenOne(tabName = "mimi ndio kusema", match = match)

        }

    }

}