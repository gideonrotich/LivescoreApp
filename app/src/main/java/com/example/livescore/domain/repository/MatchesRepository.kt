package com.example.livescore.domain.repository

import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.util.Resource
import kotlinx.coroutines.flow.Flow


interface MatchesRepository {
    fun getMatches(): Flow<Resource<List<DataModel>>>
    fun getMatchDetails(id:String):Flow<Resource<MatchDetailsModel>>
}