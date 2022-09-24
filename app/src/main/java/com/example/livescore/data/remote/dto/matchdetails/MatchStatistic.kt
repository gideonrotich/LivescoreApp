package com.example.livescore.data.remote.dto.matchdetails

data class MatchStatistic(
    val attacks: Int,
    val ball_safe: Int,
    val corners: Int,
    val dangerous_attacks: Int,
    val fouls: Int,
    val free_kick: Int,
    val goal_attempts: Int,
    val goal_kick: Int,
    val goals: Int,
    val injuries: Int,
    val offsides: Int,
    val penalties: Int,
    val possessionpercent: Int,
    val possessiontime: Int,
    val redcards: Int,
    val shots_blocked: Int,
    val shots_off_target: Int,
    val shots_on_target: Int,
    val shots_total: Int,
    val substitutions: Int,
    val team_id: Int,
    val team_name: String,
    val throw_in: Int,
    val yellowcards: Int,
    val yellowredcards: Int
)