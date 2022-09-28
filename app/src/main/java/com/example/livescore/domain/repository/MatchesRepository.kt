package com.example.livescore.domain.repository

import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.domain.models.OddsModel
import com.example.livescore.domain.models.StandingsModel
import com.example.livescore.util.Resource
import kotlinx.coroutines.flow.Flow


interface MatchesRepository {
    fun getMatches(): Flow<Resource<List<DataModel>>>
    fun getStandings(): Flow<Resource<List<StandingsModel>>>
    fun getMatchDetails(id:String):Flow<Resource<MatchDetailsModel>>
    fun getOdds(id:String):Flow<Resource<OddsModel>>
}