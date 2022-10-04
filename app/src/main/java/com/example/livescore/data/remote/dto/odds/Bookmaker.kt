package com.example.livescore.data.remote.dto.odds

data class Bookmaker(
    val bookmaker_id: Int,
    val bookmaker_name: String,
    val last_updated: String,
    val odds_data: OddsData
)
