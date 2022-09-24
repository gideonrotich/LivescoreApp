package com.example.livescore.presentation.screens.matchdetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.livescore.presentation.screens.matches.components.MatchesViewModel

@Composable
fun MatchDetailsScreen(
    matchdetailsViewModel: MatchDetailsViewModel = hiltViewModel()
){
    val matchesState = matchdetailsViewModel.state.value
    val context = LocalContext.current

}