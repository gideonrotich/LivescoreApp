package com.example.livescore.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.livescore.data.remote.dto.*

@Entity(tableName = "matches_table")
data class MatchesEntity(
    val away_team: AwayTeam,
    val group: Group,
    val home_team: HomeTeam,
    val league_id: Int,
    @PrimaryKey(autoGenerate = false)
    val match_id: Int,
    val match_start: String,
    val match_start_iso: String,
    val minute: String,
    val referee_id: String,
    val round: Round,
    val season_id: Int,
    val stage: Stage,
    val stats: Stats,
    val status: String,
    val status_code: Int,
    val venue: Venue
)
