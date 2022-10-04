package com.example.livescore.presentation.screens.scorers.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.livescore.presentation.screens.scorers.ScorersViewModel

@Composable
fun ScorersScreen(viewModel: ScorersViewModel = hiltViewModel()) {

    val scorerstate = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.three), contentDescription = "",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth().fillMaxHeight(),
                contentScale = ContentScale.Crop
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
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "Player name",
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.width(120.dp))
                    Text(
                        text = "Goals",
                        fontSize = 14.sp
                    )
                }
            }
            LazyColumn() {
                items(scorerstate.scorer) { scorer ->
                    ScorerListItem(
                        scorer = scorer,
                    )
                }
            }
        }
        if (scorerstate.error.isNotBlank()) {
            Text(
                text = scorerstate.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (scorerstate.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colorResource(
                    id = R.color.purple
                )
            )
        }
    }
}
