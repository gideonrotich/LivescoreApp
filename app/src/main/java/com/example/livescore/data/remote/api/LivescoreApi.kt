package com.example.livescore.data.remote.api

import com.example.livescore.data.remote.dto.MatchesResponseDto
import com.example.livescore.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface LivescoreApi {
    @GET(Constants.GET_MATCHES)
    suspend fun getMatches(
        @Query("apikey") apikey: String = Constants.API_KEY_TWO,
        @Query("season_id") seasonId: String = Constants.PL_ID_MATCHES,
        @Query("date_from") dateFrom: String = "2021-08-13",
        @Query("date_to") dateTo: String = "2022-05-23"
    ):MatchesResponseDto
}