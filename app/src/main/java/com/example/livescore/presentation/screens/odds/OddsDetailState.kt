package com.example.livescore.presentation.screens.odds

import com.example.livescore.domain.models.OddsModel

data class OddsDetailState(
    val error:String = "",
    val odds:OddsModel? = null,
    val isLoading:Boolean = false
)
