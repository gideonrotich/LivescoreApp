package com.example.livescore.presentation.screens.matches

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.livescore.presentation.screens.matches.components.MatchesViewModel
import com.example.livescore.presentation.screens.matches.components.TopBar
import com.example.livescore.presentation.screens.matches.components.UpcomingMatchesItem

@Composable
fun MatchesScreen(navController: NavHostController, matchesViewModel: MatchesViewModel = hiltViewModel()) {

    val matchesState = matchesViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar(title = "Livescore")
            Spacer(Modifier.height(15.dp))


            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(matchesState.matches) { matches ->
                    UpcomingMatchesItem(match = matches)
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
}