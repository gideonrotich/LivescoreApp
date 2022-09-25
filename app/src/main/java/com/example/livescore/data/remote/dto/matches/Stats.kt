package com.example.livescore.data.remote.dto.matches

data class Stats(
    val away_score: Int,
    val et_score: Any,
    val ft_score: String,
    val home_score: Int,
    val ht_score: String,
    val ps_score: Any
)