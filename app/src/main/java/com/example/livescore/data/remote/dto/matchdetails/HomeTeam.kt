package com.example.livescore.data.remote.dto.matchdetails

data class HomeTeam(
    val common_name: String,
    val country: Country,
    val logo: String,
    val name: String,
    val short_code: String,
    val team_id: Int
)
