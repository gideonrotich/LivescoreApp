package com.example.livescore.presentation.screens.matchdetails

import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.models.MatchDetailsModel

data class MatchDetailsState(
    val isLoading:Boolean = false,
    val error:String = "",
    val matchdetails:MatchDetailsModel? = null
)
