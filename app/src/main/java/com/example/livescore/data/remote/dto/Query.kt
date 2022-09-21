package com.example.livescore.data.remote.dto

data class Query(
    val apikey: String,
    val date_from: String,
    val season_id: String
)