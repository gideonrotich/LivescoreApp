package com.example.livescore.data.remote.dto.matchdetails

data class Lineup(
    val formation: String,
    val formation_confirmed: Int,
    val players: List<Player>,
    val team_id: Int
)
