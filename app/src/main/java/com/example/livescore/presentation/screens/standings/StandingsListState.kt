package com.example.livescore.presentation.screens.standings

import com.example.livescore.domain.models.StandingsModel

data class StandingsListState(
    val isLoading:Boolean = false,
    val error:String = "",
    val standings:List<StandingsModel> = emptyList()
)
