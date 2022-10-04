package com.example.livescore.data.remote.dto.matchdetails

data class MatchEvent(
    val extra_minute: Int,
    val injured: String,
    val minute: Int,
    val own_goal: Boolean,
    val penalty: Boolean,
    val player_id: Int,
    val player_name: String,
    val reason: Any,
    val related_player_id: Int,
    val related_player_name: String,
    val result: String,
    var team_id: Int,
    var type: String
)
