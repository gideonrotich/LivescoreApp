package com.example.livescore.domain.use_cases

import com.example.livescore.domain.models.StandingsModel
import com.example.livescore.domain.repository.MatchesRepository
import com.example.livescore.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStandingsUseCase @Inject constructor(
    private val repository: MatchesRepository
) {
    operator fun invoke():Flow<Resource<List<StandingsModel>>>{
        return repository.getStandings()
    }
}