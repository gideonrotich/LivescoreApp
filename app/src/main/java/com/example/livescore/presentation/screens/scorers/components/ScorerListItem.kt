package com.example.livescore.presentation.screens.scorers.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.livescore.domain.models.ScorersModel
import com.example.livescore.presentation.screens.standings.components.getTeamLogo

@Composable
fun ScorerListItem(scorer: ScorersModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 14.dp, end = 20.dp)
        ) {
            Text(
                text = scorer.pos.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = rememberImagePainter(getTeamLogo(scorer)),
                contentDescription = "Team logo",
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = scorer.player.player_name,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .width(200.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = scorer.team.team_name,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .width(200.dp),
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = scorer.goals.overall.toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
        }
        Spacer(modifier = Modifier.height(12.dp))

        Divider(color = Color.LightGray, thickness = 0.4.dp)
    }
}

fun getTeamLogo(standings: ScorersModel): String {
    return when (standings.team.team_id) {
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
