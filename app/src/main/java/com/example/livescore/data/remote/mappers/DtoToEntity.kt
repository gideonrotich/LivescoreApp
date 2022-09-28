package com.example.livescore.data.remote.mappers

import com.example.livescore.data.remote.dto.matches.Data
import com.example.livescore.data.remote.dto.standings.Standing
import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.domain.models.OddsModel
import com.example.livescore.domain.models.StandingsModel

internal fun Standing.toEntity():StandingsModel {
    return StandingsModel(away, home, overall, points, position, result, status, team_id)

}

internal fun com.example.livescore.data.remote.dto.odds.Data.toEntity():OddsModel{
    return OddsModel(FullTimeResult,AsianHandicap,OverUnder)
}


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

internal fun com.example.livescore.data.remote.dto.matchdetails.Data.toEntity():MatchDetailsModel{
    return MatchDetailsModel(
        away_team, group, home_team, league_id, lineups, match_events, match_id, match_start, match_start_iso, match_statistics, minute, referee_id, round, season_id, stage, stats, status, status_code, venue
    )
}

