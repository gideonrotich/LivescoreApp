package com.example.livescore.data.remote.dto.scorers

data class Data(
    val goals: Goals,
    val league_id: Int,
    val matches_played: Int,
    val minutes_played: Int,
    val penalties: Int,
    val player: Player,
    val pos: Int,
    val season_id: Int,
    val substituted_in: Int,
    val team: Team
)
