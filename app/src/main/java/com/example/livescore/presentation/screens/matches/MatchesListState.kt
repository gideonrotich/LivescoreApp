package com.example.livescore.presentation.screens.matches

import com.example.livescore.domain.models.DataModel

data class MatchesListState(
    val isLoading:Boolean = false,
    val error:String = "",
    val matches:List<DataModel> = emptyList()
)
