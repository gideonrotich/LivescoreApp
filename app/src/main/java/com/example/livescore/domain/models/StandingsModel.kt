package com.example.livescore.domain.models

import com.example.livescore.data.remote.dto.standings.Away
import com.example.livescore.data.remote.dto.standings.Home
import com.example.livescore.data.remote.dto.standings.Overall

data class StandingsModel(
    val away: Away?,
    val home: Home?,
    val overall: Overall?,
    val points: Int?,
    val position: Int?,
    val result: String?,
    val status: String?,
    val team_id: Int?
)
