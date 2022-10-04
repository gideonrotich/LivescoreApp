package com.example.livescore.presentation.screens.matchdetails.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.livescore.R
import com.example.livescore.data.remote.dto.matchdetails.Lineup
import com.example.livescore.data.remote.dto.matchdetails.MatchEvent
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.ui.theme.SpAtkColor

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
fun TabScreenThree(tabName: String, stata: MatchDetailsModel) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(6.dp),
        elevation = 3.dp,

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize()
        ) {
            PokemonBaseStats(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            AttacksAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            BallSafeAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            CornersAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            DangerousAttacksAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            FoulsAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            FreeKickAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            GoalAttemptsAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            GoalKickAnimation(pokemonInfo = stata)
            Spacer(modifier = Modifier.height(8.dp))
            GoalsAnimation(pokemonInfo = stata)
        }
    }
}

@Composable
fun PokemonBaseStats(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.shots_on_target }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Shots on Target",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "Shots on target",
                    statValue = stat.shots_on_target,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 15.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercent = animateFloatAsState(
        targetValue = if (animationPlayed) {
            statValue / statMaxValue.toFloat()
        } else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(height)
            .clip(CircleShape)
            .background(
                if (isSystemInDarkTheme()) {
                    Color(0xFF505050)
                } else {
                    Color.LightGray
                }
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp)
        ) {

            Text(
                text = (curPercent.value * statMaxValue).toInt().toString(),
                fontWeight = FontWeight.Bold, color = Color.White
            )
        }
    }
}

@Composable
fun AttacksAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.attacks }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Attacks",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.attacks,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun BallSafeAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.ball_safe }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Ball safe",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.ball_safe,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun CornersAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.corners }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Corners",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.corners,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun DangerousAttacksAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.dangerous_attacks }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Dangerous attacks",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.dangerous_attacks,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun FoulsAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.fouls }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Fouls",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.fouls,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun FreeKickAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.free_kick }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Free kicks",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.free_kick,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun GoalAttemptsAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.goal_attempts }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Goal attempts",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.goal_attempts,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun GoalKickAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.goal_kick }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Goal kick",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.goal_kick,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun GoalsAnimation(
    pokemonInfo: MatchDetailsModel,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.match_statistics.maxOf { it.goals }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Goals",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in pokemonInfo.match_statistics.indices) {
                val stat = pokemonInfo.match_statistics[i]
                PokemonStat(
                    statName = "",
                    statValue = stat.goals,
                    statMaxValue = maxBaseStat,
                    statColor = SpAtkColor,
                    animDelay = i * animDelayPerItem
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
