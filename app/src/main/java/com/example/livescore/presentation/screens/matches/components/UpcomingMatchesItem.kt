package com.example.livescore.presentation.screens.matches.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.unit.dp
import com.example.livescore.domain.models.DataModel
import com.example.livescore.ui.theme.Teal200

@Composable
fun UpcomingMatchesItem(match:DataModel){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp,
        backgroundColor = DarkGray
    ){
        Box(modifier = Modifier.height(150.dp)){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Text(
                    text = "${match.home_team}",
                    style = MaterialTheme.typography.body1,
                    color = Teal200
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "${match.away_team}",
                    style = MaterialTheme.typography.body1,
                    color = Teal200
                )
            }
        }
    }
}