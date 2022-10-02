package com.example.livescore.data.remote.api

import com.example.livescore.data.remote.dto.matchdetails.MatchDetailsDto
import com.example.livescore.data.remote.dto.matches.MatchesResponseDto
import com.example.livescore.data.remote.dto.odds.OddsResponseDto
import com.example.livescore.data.remote.dto.standings.StandingsResponseDto
import com.example.livescore.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LivescoreApi {

    //get matches
    @GET(Constants.GET_MATCHES)
    suspend fun getMatches(
        @Query("apikey") apikey: String = Constants.API_KEY_TWO,
        @Query("season_id") seasonId: String = Constants.PL_ID_MATCHES,
        @Query("date_from") dateFrom: String = "2021-08-13",
        @Query("date_to") dateTo: String = "2022-05-23"
    ): MatchesResponseDto

    //get match details
    @GET(Constants.GET_MATCH_DETAILS)
    suspend fun getMatchDetails(
        @Path("id")id: String,
        @Query("apikey") apikey: String = Constants.API_KEY_TWO
    ): MatchDetailsDto

    //get league standings
    @GET(Constants.GET_STANDINGS)
    suspend fun geStandings(
        @Query("apikey") apikey: String = Constants.API_KEY_TWO,
        @Query("season_id") seasonId: String = Constants.PL_ID_MATCHES,
    ): StandingsResponseDto

    //get match odds
    @GET(Constants.GET_ODDS)
    suspend fun getOdds(
        @Path("id")id:String,
        @Query("apikey") apikey: String = Constants.API_KEY_TWO,
        @Query("type")type:String = "prematch",
    ): OddsResponseDto
}