package com.example.livescore.presentation.screens.matchdetails

import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.domain.models.OddsModel

data class MatchDetailsState(
    val isLoading:Boolean = false,
    val error:String = "",
    val matchdetails:MatchDetailsModel? = null,
    val odds:OddsModel? = null
)
