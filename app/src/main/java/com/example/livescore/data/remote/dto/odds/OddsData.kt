package com.example.livescore.data.remote.dto.odds

data class OddsData(
    val away: String,
    val draw: String,
    val handicap: Any,
    val home: String,
    val minute: Any,
    val over: Any,
    val score: Any,
    val under: Any
)
