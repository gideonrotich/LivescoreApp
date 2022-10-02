package com.example.livescore.presentation.screens.scorers

import com.example.livescore.domain.models.ScorersModel

data class ScorersDataState(
    val isLoading:Boolean = false,
    val error:String = "",
    val scorer:List<ScorersModel> = emptyList()
)
