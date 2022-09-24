package com.example.livescore.domain.models

import com.example.livescore.data.remote.dto.standings.Standing

data class StandingsModel(
    val has_groups: Int,
    val league_id: Int,
    val season_id: Int,
    val standings: List<Standing>
)
