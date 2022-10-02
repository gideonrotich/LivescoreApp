package com.example.livescore.domain.models

import com.example.livescore.data.remote.dto.scorers.Goals
import com.example.livescore.data.remote.dto.scorers.Player
import com.example.livescore.data.remote.dto.scorers.Team

data class ScorersModel(
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
