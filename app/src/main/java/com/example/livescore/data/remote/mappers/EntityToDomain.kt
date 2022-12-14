package com.example.livescore.data.remote.mappers

import com.example.livescore.data.local.entity.MatchDetailsEntity
import com.example.livescore.data.local.entity.MatchesEntity
import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.models.MatchDetailsModel

internal fun MatchesEntity.toDomain(): DataModel {
    return DataModel(
        this.away_team,
        this.group,
        this.home_team,
        this.league_id,
        this.match_id,
        this.match_start,
        this.match_start_iso,
        this.minute,
        this.referee_id,
        this.round,
        this.season_id,
        this.stage,
        this.stats,
        this.status,
        this.status_code,
        this.venue
    )
}

internal fun MatchDetailsEntity.toDomain(): MatchDetailsModel {
    return MatchDetailsModel(
        away_team, group, home_team, league_id, lineups, match_events, match_id, match_start, match_start_iso, match_statistics, minute, referee_id, round, season_id, stage, stats, status, status_code, venue
    )
}
