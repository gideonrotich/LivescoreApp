package com.example.resources

import com.example.livescore.data.local.entity.MatchesEntity
import com.example.livescore.data.remote.dto.matches.*

val fakeMatch = MatchesEntity(
    match_id = 2,
    away_team = AwayTeam("Brentford",Country("","",2,""),"","","",2),
    match_start = "23",
    group = Group(2,""),
    match_start_iso = "",
    home_team = HomeTeam("Arsenal",Country("","",2,""),"","","",3),
    league_id = 5,
    minute = "4",
    referee_id = "45",
    round = Round("","",4),
    season_id = 3,
    stage = Stage("",8),
    stats = Stats(2,2,"4",5,"",5),
    status = "complete",
    status_code = 4,
    venue = Venue(3,"wembley",3,"",4)
)