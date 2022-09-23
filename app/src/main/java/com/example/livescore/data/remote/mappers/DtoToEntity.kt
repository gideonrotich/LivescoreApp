package com.example.livescore.data.remote.mappers

import com.example.livescore.data.local.entity.MatchesEntity
import com.example.livescore.data.remote.dto.Data
import com.example.livescore.domain.models.DataModel

internal fun Data.toEntity():DataModel{
    return DataModel(
        this.away_team,
        this.group,
        this.home_team,
        this.league_id,
        this.match_id,
        this.match_start,
        this.match_start_iso,
        this.minute,
        this.match_start,
        this.round,
        this.season_id,
        this.stage,
        this.stats,
        this.status,
        this.status_code,
        this.venue,
    )
}