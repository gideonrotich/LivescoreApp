package com.example.livescore.presentation.screens.standings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.livescore.domain.models.StandingsModel

@Composable
fun StandingsListItem(standings: StandingsModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 14.dp, end = 20.dp)
        ) {
            Text(
                text = PosConverter(standings),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(10.dp))
            if (standings.result == "Champions League") {
                Image(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Green),
                    modifier = Modifier
                        .size(20.dp)
                        .align(CenterVertically)
                )
            }
            if (standings.result == "UEFA Europa League") {
                Image(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Gray),
                    modifier = Modifier
                        .size(20.dp)
                        .align(CenterVertically)
                )
            }
            if (standings.result == "Conference League Qualification") {
                Image(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.LightGray),
                    modifier = Modifier
                        .size(20.dp)
                        .align(CenterVertically)
                )
            }
            if (standings.result == "Relegation") {
                Image(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Red),
                    modifier = Modifier
                        .size(20.dp)
                        .align(CenterVertically)
                )
            }

            if (standings.status == "Same") {
                Card(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(6.dp),
                    shape = RoundedCornerShape(100.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .background(Color.LightGray)
                            .padding()
                    ) {
                    }
                }
            }

            Spacer(modifier = Modifier.width(6.dp))

            Image(
                painter = rememberImagePainter(getTeamLogo(standings)),
                contentDescription = "Team logo",
                modifier = Modifier
                    .size(28.dp)
                    .align(CenterVertically)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = TeamConverter(standings),
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = standings.overall?.games_played.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = standings.overall?.won.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = standings.overall?.draw.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = standings.overall?.lost.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = standings.overall?.goals_diff.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = standings.points.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

        Divider(color = Color.LightGray, thickness = 0.4.dp)
    }
}

fun TeamConverter(standings: StandingsModel): String {
    return when (standings.team_id) {
        12400 -> "MCI"
        2509 -> "LIV"
        2524 -> "CHE"
        2522 -> "TOT"
        12295 -> "ARS"
        2523 -> "MUN"
        12401 -> "WHU"
        850 -> "LEI"
        849 -> "BHA"
        12424 -> "WOL"
        2518 -> "NEW"
        2537 -> "CRY"
        12423 -> "BRE"
        2515 -> "AVL"
        2520 -> "SOU"
        2546 -> "EVE"
        2513 -> "LEE"
        2516 -> "BUR"
        2517 -> "WAT"
        2510 -> "NOR"
        else -> "Unknown team"
    }.toString()
}

fun getTeamLogo(standings: StandingsModel): String {
    return when (standings.team_id) {
        12400 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/4.png"
        2509 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/1.png"
        2524 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/20.png"
        2522 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/13.png"
        12295 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/18.png"
        2523 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/19.png"
        12401 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/3.png"
        850 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/15.png"
        849 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/12.png"
        12424 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/16.png"
        2518 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/17.png"
        2537 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/9.png"
        12423 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/265.png"
        2515 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/14.png"
        2520 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/8.png"
        2546 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/10.png"
        2513 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/274.png"
        2516 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/7.png"
        2517 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/11.png"
        2510 -> "https://cdn.sportdataapi.com/images/soccer/teams/100/2.png"

        else -> "No team logo"
    }.toString()
}

fun PosConverter(standings: StandingsModel): String {
    return when (standings.position) {
        1 -> "01"
        2 -> "02"
        3 -> "03"
        4 -> "04"
        5 -> "05"
        6 -> "06"
        7 -> "07"
        8 -> "08"
        9 -> "09"
        10 -> "10"
        11 -> "11"
        12 -> "12"
        13 -> "13"
        14 -> "14"
        15 -> "15"
        16 -> "16"
        17 -> "17"
        18 -> "18"
        19 -> "19"
        20 -> "20"
        else -> "0"
    }
}
