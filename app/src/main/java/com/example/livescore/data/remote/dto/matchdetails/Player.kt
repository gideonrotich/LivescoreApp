package com.example.livescore.data.remote.dto.matchdetails

data class Player(
    val age: Int,
    val birthday: String,
    val country: Country,
    val detailed: Detailed,
    val firstname: String,
    val height: Int,
    val img: String,
    val lastname: String,
    val player_id: Int,
    val weight: Int
)