package com.example.livescore.domain.models

import com.example.livescore.data.remote.dto.odds.AsianHandicap
import com.example.livescore.data.remote.dto.odds.OverUnderGoalLine
import com.example.livescore.data.remote.dto.odds.X2FullTimeResult

data class OddsModel(
    val FullTimeResult: X2FullTimeResult,
    val AsianHandicap: AsianHandicap,
    val OverUnder: OverUnderGoalLine
)
